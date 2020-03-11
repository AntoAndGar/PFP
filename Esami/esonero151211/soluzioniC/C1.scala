object C1 {
    def ifElse(test:Boolean)(ifBody: =>Unit)(elseBody: =>Unit) =
        if (test) ifBody else elseBody
}
