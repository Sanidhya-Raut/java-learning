
Functional Interface - A Functional Interface in Java is an interface that contains exactly one abstract method.


            Method Signature                    Purpose                               Real-world Stream Example
--------------------------------------------------------------------------------------------------------------------
Predicate    boolean test(T t)      Takes 1 argument, returns a boolean.        .filter(emp -> emp.getAge() > 25)
                                        Used for filtering.                      



Consumer    void accept(T t)        Takes 1 argument, consumes it,               .forEach(System.out::println)
                                        returns nothing.



Supplier        T get()             Takes 0 arguments, creates/supplies         .orElseGet(() -> new Employee())
                                                an object.  


Function        R apply(T t)            Takes 1 argument, transforms it,        .map(Employee::getSalary)
                                        returns a result.

----------------------------------------------------------------------------------------------------------
Why are Streams considered lazy?
Streams are considered lazy because intermediate operations (like filter, map)
do not execute until a terminal operation (like collect, forEach) is invoked.

Why doesn't the original list change?
Streams are designed to support immutability and side-effect-free programming.

Why does filter() return a Stream?
filter() returns a Stream to allow method chaining (fluent pipeline structure).