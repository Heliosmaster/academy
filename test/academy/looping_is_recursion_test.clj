(ns academy.looping-is-recursion-test
  (:require [clojure.test :refer :all]
            [academy.looping-is-recursion :refer :all]))

(deftest power-test
  (is (= (power 2 2) 4))
  (is (= (power 5 3) 125))
  (is (= (power 7 0) 1))
  (is (= (power 0 10) 0)))

(deftest last-element-test
  (is (nil? (last-element [])))
  (is (= (last-element [1 2 3]) 3))
  (is (= (last-element [2 5]) 5)))

(deftest seq=-test
  (is (seq= [1 2 4] '(1 2 4)))
  (is (seq= [] []))
  (is (not (seq= [1 2 nil] [1 2])))
  (is (not (seq= [1 4 2] [1 2 4])))
  (is (not (seq= [1 2 3] [1 2 3 4])))
  (is (not (seq= [1 3 5] []))))

(deftest find-first-index-test
  (is (= (find-first-index zero? [1 1 1 0 3 7 0 2]) 3))
  (is (= (find-first-index zero? [1 1 3 7 2]) nil))
  (is (= (find-first-index #(= % 6) [:cat :dog :six :blorg 6]) 4))
  (is (= (find-first-index nil? []) nil)))

(deftest avg-test
  (is (= (avg [1 2 3]) 2))
  (is (= (avg [0 0 0 4]) 1))
  (is (= (avg [1 0 0 1])
         (/ 1 2))))

(deftest parity-test
  (is (= (set (parity [:a :b :c])) #{:a :b :c}))
  (is (= (set (parity [:a :b :c :a])) #{:b :c}))
  (is (= (set (parity [1 1 2 1 2 3 1 2 3 4])) #{2 4})) )

(deftest fast-fibo
  (is (= (fast-fibo 0) 0))
  (is (= (fast-fibo 1) 1))
  (is (= (fast-fibo 2) 1))
  (is (= (fast-fibo 3) 2))
  (is (= (fast-fibo 85) 259695496911122585)))

(deftest cut-at-repetition
  (is (= (cut-at-repetition [1 1 1 1 1]) [1]))
  (is (= (cut-at-repetition [:cat :dog :house :milk 1 :cat :dog]) [:cat :dog :house :milk 1]))
  (is (= (cut-at-repetition [0 1 2 3 4 5]) [0 1 2 3 4 5])))