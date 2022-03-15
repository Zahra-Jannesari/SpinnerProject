package com.zarisa.moneyproject

object DataBank {
    var oneUSDtoEUR=0.91
    var oneUSDtoIRR=42350.00
    var oneEURtoIRR=46404.17
    fun convertor(firstType:String,secondType:String,amount:Double?):Double{
        return when(firstType){
            "USD"->convertUSD(secondType,amount)
            "IRR"->convertIRR(secondType,amount)
            else->convertEUR(secondType,amount)
        }
    }
    private fun convertEUR(secondType: String, amount: Double?):Double {
        if (amount != null) {
            return when(secondType){
                "USD"->amount/oneUSDtoEUR
                "IRR"->amount*oneEURtoIRR
                else->amount* 1
            }
        }
        else return 0.0
    }
    private fun convertIRR(secondType: String, amount: Double?):Double {
        if (amount != null) {
            return when(secondType){
                "USD"->amount/ oneUSDtoIRR
                "IRR"->amount*1
                else->amount/oneEURtoIRR
            }
        }
        else return 0.0
    }
    private fun convertUSD(secondType: String,amount:Double?):Double {
        if (amount != null) {
            return when(secondType){
                "USD"->amount*1
                "IRR"->amount*oneUSDtoIRR
                else->amount* oneUSDtoEUR
            }
        }
        else return 0.0
    }
}