package com.example.fakeaccountdetector

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView

class ReportAdapter(
    private val reports: List<Report>,
    private val onReAnalyze: (Report) -> Unit,
    private val onDelete: (Report) -> Unit
) : RecyclerView.Adapter<ReportAdapter.ReportViewHolder>() {

    inner class ReportViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvTimestamp: TextView = view.findViewById(R.id.tvTimestamp)
        val tvScore: TextView = view.findViewById(R.id.tvScore)
        val progressBarScore: ProgressBar = view.findViewById(R.id.progressBarScore)
        val btnReAnalyze: Button = view.findViewById(R.id.btnReAnalyze)
        val btnDelete: TextView = view.findViewById(R.id.btnDelete)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReportViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_report, parent, false)
        return ReportViewHolder(view)
    }

    override fun onBindViewHolder(holder: ReportViewHolder, position: Int) {
        val report = reports[position]
        holder.tvTimestamp.text = report.timestamp
        holder.tvScore.text = "${report.trustScore}%"
        holder.progressBarScore.progress = report.trustScore

        holder.btnReAnalyze.setOnClickListener { onReAnalyze(report) }
        holder.btnDelete.setOnClickListener { onDelete(report) }
    }

    override fun getItemCount(): Int = reports.size
}
