class A {
    def text = "superclasse A"
}

class B extends A {
    override def text = "sottoclasse B"
}

class C extends A {
    override def text = "sottoclasse C"
}

def sottoclasse[T<:A](x:T) = x.text

val x = new C()

sottoclasse(x)
sottoclasse(new A())
sottoclasse(new B())
sottoclasse(new C())

class D
sottoclasse(new D()) // type bound error

def min[T](l:List[T]) = { // errore nessuno ci garantisce che T sia ordinabile
    l.reduce((a,b) => if(a<b) a else b)
}

def min2[T <% Ordered[T]](l:List[T]) = {
    l.reduce((a,b) => if(a<b) a else b)
}

min(List(4,2,7,8))

def min3[T](l:List[T])(implicit cmp: T=>Int) = {
    l.reduce((a,b) => if(a<b) a else b)
}

min3(List(4,2,7,8))