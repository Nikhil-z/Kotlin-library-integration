package com.nikhilz.sam.adapter

import android.app.Activity
import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Filter
import com.nikhilz.sam.model.AutoCompleteModel
import kotlinx.android.synthetic.main.item.view.*

import java.util.ArrayList

class AutoCompleteAdapter(
    private val mContext: Context,
    private val mLayoutResourceId: Int,
    autoCompleteModels: List<AutoCompleteModel>
) : ArrayAdapter<AutoCompleteModel>(mContext, mLayoutResourceId, autoCompleteModels) {
    private val mAutoCompleteModels: MutableList<AutoCompleteModel>
    private val mAutoCompeletAll: List<AutoCompleteModel>

    init {
        this.mAutoCompleteModels = ArrayList(autoCompleteModels)
        this.mAutoCompeletAll = ArrayList(autoCompleteModels)
    }

    override fun getCount(): Int {
        return mAutoCompleteModels.size
    }

    override fun getItem(position: Int): AutoCompleteModel? {
        return mAutoCompleteModels[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        var view: View? = convertView
        if (view == null) {
            val inflater = (mContext as Activity).layoutInflater
            view = inflater.inflate(mLayoutResourceId, parent, false)
        }
        val autoCompleteModel = getItem(position)

        view!!.textView.text = autoCompleteModel!!.title
        view.textView2.text = autoCompleteModel.subtitle


        return view
    }


    override fun getFilter(): Filter {
        return object : Filter() {
            override fun convertResultToString(resultValue: Any): String? {
                return (resultValue as AutoCompleteModel).title
            }

            override fun performFiltering(constraint: CharSequence?): Filter.FilterResults {
                val filterResults = Filter.FilterResults()
                val suggestion = ArrayList<AutoCompleteModel>()
                if (constraint != null) {
                    for (autoCompleteModel in mAutoCompeletAll) {
                        if (autoCompleteModel.title!!.toLowerCase().startsWith(constraint.toString().toLowerCase())) {
                            suggestion.add(autoCompleteModel)
                        }
                    }
                    filterResults.values = suggestion
                    filterResults.count = suggestion.size
                }
                return filterResults
            }

            override fun publishResults(constraint: CharSequence?, results: Filter.FilterResults?) {
                mAutoCompleteModels.clear()
                if (!(results == null || results.count <= 0)) {
                    // avoids unchecked cast warning when using mAutoCompleteModels.addAll((ArrayList<AutoCompleteModel>) results.values);
                    for (`object` in results.values as List<*>) {
                        if (`object` is AutoCompleteModel) {
                            mAutoCompleteModels += `object`
                        }
                    }
                    notifyDataSetChanged()
                } else if (constraint == null) {
                    // no filter, add entire original list back in
                    mAutoCompleteModels.addAll(mAutoCompeletAll)
                    notifyDataSetInvalidated()
                }
            }
        }
    }
}