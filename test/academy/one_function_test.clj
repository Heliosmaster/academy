(ns academy.one-function-test
  (:require [clojure.test :refer :all]
            [academy.one-function :refer :all]))


(deftest concat-elements-test
  (is (= (concat-elements []) '()))
  (is (= (concat-elements [[1 2]]) '(1 2)))
  (is (= (concat-elements [[1 2] [3 4]]) '(1 2 3 4)))
  (is (= (concat-elements [[1 2 2] [2 3]]) '(1 2 2 2 3)))
  (is (= (concat-elements [[[1] [2]] [[3]]]) '([1] [2] [3]))))

(deftest str-cat-test
  (is (= (str-cat ["I" "am" "Legend"]) "I am Legend"))
  (is (= (str-cat ["I" "am" "back"]) "I am back"))
  (is (= (str-cat ["more" " " "space"]) "more   space"))
  (is (= (str-cat []) "")))

(deftest my-interpose-test
  (is (= (my-interpose 0 [1 2 3]) [1 0 2 0 3]))
  (is (= (my-interpose "," ["I" "me" "myself"]) '("I" "," "me" "," "myself")))
  (is (= (my-interpose :a [[1] [2] [3]]) '([1] :a [2] :a [3])))
  (is (= (my-interpose :a [1]) [1]))
  (is (= (my-interpose :a []) [])))

(deftest my-count-test
  (is (= (my-count []) 0))
  (is (= (my-count [1 2 3]) 3))
  (is (= (my-count [1]) 1)))

(deftest my-reverse-test
  (is (= (my-reverse [1 2 3]) '(3 2 1)))
  (is (= (my-reverse [1 2 2 3 3]) '(3 3 2 2 1)))
  (is (= (my-reverse [1 2]) '(2 1)))
  (is (= (my-reverse [[1] [2]]) '([2] [1])))
  (is (= (my-reverse []) '())))

(deftest min-max-element-test
  (is (= (min-max-element [2 7 3 15 4]) [2 15]))
  (is (= (min-max-element [1 2 3 4]) [1 4]))
  (is (= (min-max-element [1]) [1 1])))


(deftest insert-test
  (is (= (insert [] 2) '(2)))
  (is (= (insert [1 3 4] 2) '(1 2 3 4)))
  (is (= (insert [3 5 7] 2) '(2 3 5 7)))
  (is (= (insert [1] 2) '(1 2))))

(deftest insertion-sort-test
  (is (= (insertion-sort [2 5 3 1]) '(1 2 3 5)))
  (is (= (insertion-sort (shuffle (range 100))) (range 100)))
  (is (= (insertion-sort [1 2]) '(1 2))))

(deftest parity-test
  (is (= (parity [:a :b :c]) #{:a :b :c}))
  (is (= (parity [:a :a :b :b]) #{}))
  (is (= (parity [1 2 3 1]) #{2 3})))

(deftest minus-test
  (is (= (minus 2) -2))
  (is (= (minus 4 3) 1)))

(deftest count-params-test
  (is (= (count-params) 0))
  (is (= (count-params :a) 1))
  (is (= (count-params :a 1 :b :c) 4)))

(deftest my-*-test
  (is (= (my-*) 1))
  (is (= (my-* 4 3) 12))
  (is (= (my-* 1 2 3 4 5) 120)))

(deftest pred-and-test
  (is (= (filter (pred-and) [1 0 -2]) [1 0 -2]))
  (is (= (filter (pred-and pos? odd?) [1 2 -4 0 6 7 -3]) [1 7]))
  (is (= (filter (pred-and number? integer? pos? even?) [1 0 -2 :a 7 "a" 2]) [2])))

(deftest my-map-test
  (is (= (my-map inc [1 2 3 4]) [2 3 4 5]))
  (is (= (my-map count [[1] [2 3] [4 5 6]]) [1 2 3]))
  (is (= (my-map + [1 1 1] [1 1 1] [1 1 1]) [3 3 3]))
  (is (= (my-map vector [1 2 3] [1 2 3] [1 2 3]) [[1 1 1] [2 2 2] [3 3 3]])))