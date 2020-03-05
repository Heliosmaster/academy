(ns academy.i-am-a-horse-in-a-land-of-booleans-test
  (:require [clojure.test :refer :all]
            [academy.i-am-a-horse-in-a-land-of-booleans :refer :all]))

(deftest boolean-test
  (is (boolean "foo"))
  (is (boolean "foo"))
  (is (not (boolean nil)))
  (is (boolean (+ 2 3)))
  (is (boolean true))
  (is (not (boolean false))))

(deftest teen-test
  (is (not (teen? 12)))
  (is (teen? 15))
  (is (teen? 13))
  (is (teen? 19))
  (is (not (teen? 20)))
  (is (not (teen? 27)))
  )


(deftest abs-test
  (is (= 2 (abs -2)))
  (is (= 42 (abs 42))))

(deftest divides?-test
  (is (divides? 2 4))
  (is (not (divides? 4 2)))
  (is (divides? 5 10))
  (is (not (divides? 2 5))))

(deftest fizzbuzz-test
  (is (= "" (fizzbuzz 2)))
  (is (= "gotcha!" (fizzbuzz 45)))
  (is (= "fizz" (fizzbuzz 48)))
  (is (= "buzz" (fizzbuzz 70))))

(deftest generic-doublificate-test
  (is (= 2 (generic-doublificate 1)))
  (is (= 4 (generic-doublificate [1 2])))
  (is (= 4 (generic-doublificate '(65 21))))
  (is (nil? (generic-doublificate {})))
  (is (nil? (generic-doublificate [])))
  (is (generic-doublificate {:a 1})))

(deftest not-teen-test
  (is (not (not-teen? 13)))
  (is (not-teen? 25))
  (is (not-teen? 12))
  (is (not (not-teen? 19)))
  (is (not-teen? 20)))

(deftest leap-year?-test
  (is (not (leap-year? 100)))
  (is (not (leap-year? 200)))
  (is (leap-year? 400))
  (is (leap-year? 800))
  (is (leap-year? 2000))
  (is (not (leap-year? 2200)))
  (is (leap-year? 12))
  (is (leap-year? 20))
  (is (not (leap-year? 15)))
  (is (not (leap-year? 1913))))