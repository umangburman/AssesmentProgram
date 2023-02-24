package com.example.assesmentprogram.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.assesmentprogram.R

/**
 * A RecyclerView ViewHolder to hold the views for each row of the list.
 * @param itemView The view that represents a single row in the list.
 */
class CheckBoxAdapter() : RecyclerView.Adapter<CheckBoxAdapter.CheckViewHolder>() {


    inner class CheckViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val rowNumber: TextView = itemView.findViewById(R.id.lblRowNumber)
        val checkBoxContainer: LinearLayout = itemView.findViewById(R.id.linearCheckBox)
    }

    /**
     * Called when RecyclerView needs a new [CheckViewHolder] to represent an item.
     * @param parent The ViewGroup into which the new View will be added.
     * @param viewType The type of the new View.
     * @return A new instance of [CheckViewHolder].
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CheckViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return CheckViewHolder(view)
    }

    /**
     * Returns the stable ID for the item at the given position.
     * @param position The position of the item.
     * @return The stable ID of the item.
     */
    override fun getItemId(position: Int): Long = position.toLong()

    /**
     * Returns the view type of the item at the given position.
     * @param position The position of the item.
     * @return An integer representing the view type of the item.
     */
    override fun getItemViewType(position: Int) = position

    /**
     * Returns the total number of items in the data set held by the adapter.
     * @return The total number of items.
     */
    override fun getItemCount(): Int = 100

    /**
     * Called by RecyclerView to display the data at the specified position.
     * @param holder The ViewHolder that represents the views of a single row.
     * @param position The position of the item within the adapter's data set.
     */
    override fun onBindViewHolder(holder: CheckViewHolder, position: Int) {

        holder.rowNumber.text = (position.plus(1)).toString()

        for (i in 1..position + 1) {

            val checkBox = CheckBox(holder.itemView.context)
            checkBox.text = "$i"
            holder.checkBoxContainer.addView(checkBox)
        }
    }
}