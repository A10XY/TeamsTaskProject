class Analyzer {
    fun medicalAppsPercentage(list:List<App>): Double {
        /**
         *it was solved in two ways
         */
        //use filter list

//        return if (list.isEmpty()) {
//            0.0
//        } else {
//            var listOfMedical = list.filter { it.category == "Medical" }.size
//            String.format("%.2f", listOfMedical.toDouble() / list.size * 100).toDouble()
//        }
//    }

//use forEach

        if (list.isEmpty())return 0.0
        var counter=0.0
        list.forEach {
            if (it.category=="Medical" )counter++
        }
        return String.format("%.2f",counter/list.size*100).toDouble()
    }
}