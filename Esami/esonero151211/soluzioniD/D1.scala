object D1 {
    def alterna(n:Int)(uno: =>Unit)(due: =>Unit):Unit =
        if (n<=0) () 
        else {
            uno
            due
            alterna(n-1)(uno)(due)
        }
}
