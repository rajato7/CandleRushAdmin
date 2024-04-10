package com.example.candlerushadmin

data class SubCategoryModel(
    var subCatName: String? = "",
    var subcatDescription:String?="",
    var subCatImage:String?="",
    var subCatId: String? = "",
    var categoryId: String?="",
    var subcatPrice:Int?=0
)