package com.example.model

data class BillsData(
    override val title: String,
    override val day: String,
    override val month: String,
    override val year: String
): BillsEntity {
    companion object{
        fun fakeList() = listOf(
            BillsData(title = "Market Bills", day = "02", month = "Fevereiro", year = "2024"),
            BillsData(title = "Market Bills", day = "02", month = "Fevereiro", year = "2024"),
            BillsData(title = "Market Bills", day = "02", month = "Fevereiro", year = "2024"),
            BillsData(title = "Market Bills", day = "02", month = "Fevereiro", year = "2024"),
            BillsData(title = "Market Bills", day = "02", month = "Fevereiro", year = "2024"),
            BillsData(title = "Market Bills", day = "02", month = "Fevereiro", year = "2024"),
            BillsData(title = "Market Bills", day = "02", month = "Fevereiro", year = "2024"),
            BillsData(title = "Market Bills", day = "02", month = "Fevereiro", year = "2024"),
            BillsData(title = "Market Bills", day = "02", month = "Fevereiro", year = "2024"),
            BillsData(title = "Market Bills", day = "02", month = "Fevereiro", year = "2024"),
        )
    }
}