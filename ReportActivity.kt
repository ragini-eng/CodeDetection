package com.example.fakeaccountdetector

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ReportActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: ReportAdapter
    private val reportsList = mutableListOf<Report>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_report)

        recyclerView = findViewById(R.id.reportsRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        adapter = ReportAdapter(reportsList, ::onReAnalyzeClicked, ::onDeleteClicked)
        recyclerView.adapter = adapter

        loadDummyReports()
    }

    // 🚫 No Firebase: Using dummy data instead
    private fun loadDummyReports() {
        reportsList.clear()
        reportsList.addAll(
            listOf(
                Report("2025-06-27 18:00", 72),
                Report("2025-06-27 17:45", 40),
                Report("2025-06-27 16:30", 90),
            )
        )
        adapter.notifyDataSetChanged()
    }

    private fun onReAnalyzeClicked(report: Report) {
        val intent = Intent(this, DetectPlatformActivity::class.java)
        startActivity(intent)
    }

    private fun onDeleteClicked(report: Report) {
        reportsList.remove(report)
        adapter.notifyDataSetChanged()
        Toast.makeText(this, "Deleted locally", Toast.LENGTH_SHORT).show()
    }
}
