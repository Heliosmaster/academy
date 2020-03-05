# Training day

So, you've embarked into the Journey of learning Clojure. Well done.

## Interactive REPL

One of the nice features of Clojure is the REPL. It is an interactive session in which you can write code and see it executed immediately.

You can open it, by typing in your terminal the command `clj`. You will then see something like:

```
Clojure 1.10.1
user=>
```

This means we're running a REPL for Clojure 1.10.1. You can think of `user=>` as the current "cursor" of the REPL.

Try to type "123" and press ENTER. It should look like:

```clojure
user=> 123
123
user=>
```

This means that you have **evaluated** the expression `123` which, as you can imagine, returns the value `123`. The REPL is then ready and waiting for your next command.

Let's now try a more interesting expression,

```clojure
user=> (+ 1 2)
3
user=>
```

We just evaluated the expression `(+ 1 2)`, that as you can imagine, adds up 1 and 2 and obtains 3.

## Shorthand notation for the REPL

In order to save some space, instead of writing 

```clojure
user=> (+ 1 2)
3
user=>
```

from this moment, on, we will simply write

```clojure
(+ 1 2) ;=> 3
```

On the left side there is the expression that we want to evaluate, and on the right side of `;=>` there is going to be the value of the evaluated expression.


## Prefix notation

In the example, above `(+ 1 2)` we used a notation for addition which is a bit different than what we're normally used to do for mathematical operations, and indeed different from what the majority of the other programming languages such as C and Python do.


In the table below, we see a few examples of mathematical operations in C, Java and then in Clojure

| Infix notation (C, Java) | Prefix notation (Clojure) |
|---|---|
| `1 + 2`  | `(+ 1 2)`  |
| `7 * 3` | `(* 3 7)` |
| `10 - 2*4` | `(- 10 (* 2 4))` |
| ` 1 + 2 + 3` | `(+ 1 2 3)` |

Clojure uses the [prefix notation](https://en.wikipedia.org/wiki/Polish_notation), which means we **always** put the function as the first argument in our expression. In many other languages, the mathematical operators have special properties, whereas in Clojure they don't get any preferential treatment. `+` is just a function (called `+`) as all `-`, `*`, `/`, etc. 


At first it will look a bit strange to do mathematical operations in this way, but you will soon realize that using the same behavior for all the functions (including mathematical operations) is very powerful and results in much clearer code.

**Exercise**: Now, type and evaluate the Clojure expressions in the previous table in your REPL and see their result.

## Calling a function
 
All function calls in Clojure look the same:

```clojure
(function-name arg-1 arg-2 ...)
```

As an example of a non-arithmetic function, let's consider the function `str` which concatenates strings.

```clojure
(str "Hello " "World") ;=> "Hello World"
```

Some functions, take a _variable_ number of arguments. `str` is one of these. Try the following examples in your REPL:

```clojure
(str "Hello") ;=> "Hello"
(str "Hey " "there") ;=> "Hey there"
(str "Can " "I " " really " "use " "all " "these " "arguments?") ;=> "Can I really use all these arguments?
(str) ;=> "" 
```

In the last example, we called `str` with no arguments! And it returned an empty string.

## Defining functions

So far we've called functions which are already defined in the core of the language. Programming in Clojure is, for the vast majority, defining our own functions that take and manipulate data. Clojure is a [functional language](https://en.wikipedia.org/wiki/Functional_programming) (we will explain more in the future what that means) and functions are really the back-bone of our code.

As an example, let's say we want to define our own function `hello` that takes one argument `arg1`, a string, and creates a string in which we add the string to `"Hello "`, so that, for example

```clojure
(hello "Davide") ;=> "Hello Davide"
````

The simplest way is to **define** our `hello` function as follows:

```clojure
(defn hello
  "This function greets the argument!"
  [arg1]
  (str "Hello " arg1))
```

Let's break this down:

- `defn` means we are defining a function
- `hello` is the name of our function
- `"This function greets the argument!"` is an optional docstring. 
- `[arg1]` is the list of our named arguments
- `(str "Hello " arg1)` is the body of our function

Note that in Clojure there is no need for a `return` statement, as the value of the last expression in the body of a function gets automatically returned.

Now, try to call the function `hello` with a few examples.

```clojure
(hello "Davide") ;=> "Hello Davide"
(hello "general Kenobi") ;=> "Hello general Kenobi"
```

## Defining variables

We saw and used `defn` to define a function. Sometimes, we want to define a global variable (in a namespace). We do something similar and use `def`

```clojure
(def my-name "Davide")
my-name ;=> "Davide"
```

Now try `(hello my-name)`.


## Namespaces
Code in Clojure projects is structured into namespaces defined in files. Usually each file corresponds to a one namespace identified by the file's path. For an example, the file `foo/bar/baz.clj` could contain the namespace `foo.bar.baz`. Note that underscores in file names are mapped to `-` in namespaces, and viceversa. Our namespace `academy.training-day` is under `academy/training_day.clj`. 

## Docstrings

When we defined our custom function `hello`, we specified an optional docstrings. If you want to look at the docstring of an existing function, you just type in the REPL

```clojure
(doc +)
```

And the output will be

```
clojure.core/+
([] [x] [x y] [x y & more])
  Returns the sum of nums. (+) returns 0. Does not auto-promote
  longs, will throw on overflow. See also: +'
```

Note that the function `+` is in the namespace `clojure.core`. This is kind of a special namespace of clojure, as it's always included in all the other namespaces, so you have always available the basic functions of the language. When you type `+` the REPL is looking first if you have it defined in your local namespace (`user` in our case), and if not found will look for it in all the other required namespaces, including `clojure.core`. 

If you need to look up documentation of functions, however, I also recommend taking a look at ClojureDocs, a community website in which core functions are documented with some examples. Take a look at the [documentation of `+`](https://clojuredocs.org/clojure.core/+).

# Practice time

- Edit the file `src/academy/training_day.clj`, finishing the implementation of functions
- Run, from the root directory of the project

```bash
bin/kaocha --focus academy.training-day-test
```

If all tests pass, well done! You can continue to the next lesson.