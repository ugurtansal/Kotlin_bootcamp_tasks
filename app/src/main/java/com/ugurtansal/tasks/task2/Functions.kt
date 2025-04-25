package com.ugurtansal.tasks.task2

fun main() {

}


fun calculatefahreneit(celcius:Double): Double {
    return (celcius*1.8)+32;
}

fun calculatePerimeter(longLength:Double, shortLength:Double): Double {
    return 2*(longLength+shortLength);
}

fun calculateFactorial(number:Int):Int{
    var result=1;

    for(i in 1 .. number){
        result*=i;
    }
    return result;
}


fun calculateALetter(word:String):Int{
    var count=0;
    val lowerWord=word.lowercase();

    for(i in lowerWord.indices){
        if(lowerWord[i]=='a'){
            count++;
        }
    }

    return count;
}

fun calculateInteriorAngle(sides:Int):Int{
    return (sides-2)*180;
}

fun calculateSalary(days:Int):Int{
    val hours=days*8;

    if (hours<=160){
        return hours*10;
    }else{
        return (160*10)+((hours-160)*20);
    }
}


fun calculatePayment(quota:Int):Int{
    var pay=50;
    if(quota>50){
        pay+=((quota-50)*4)
    }

    return pay;
}