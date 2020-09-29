package model

data class Account(val owner: String, val balance: Int, val created: String, val ended: String? = null)