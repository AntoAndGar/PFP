def myWhile(test: =>Boolean)(body: =>Unit): Unit = {
    if(!test)()
    else {
        body
        myWhile(test)(body)
    }
}

var i = 0
myWhile(i<10) {
    println("i=" + i);
    i += 1
}