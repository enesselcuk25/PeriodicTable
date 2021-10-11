package com.example.periodictable.model

data class DialogElements
    (
     val element:String?,
     val elementDeatail: String,
     val standartState:String?,
     val atomic:String?,
     val electron:String?,
     val oxidation:String?,
     val electronegativity:String?,
     val atomicRadius:String?,
     val ionization:String?,
     val electronAffinity:String?,
     val Melting:String?,
     val Boiling:String?,
     val Density:String?,
     val Year:String?

     ){
     val image :String
     get() = "https://images-of-elements.com/s/" + elementDeatail.lowercase() + ".jpg"
    }
