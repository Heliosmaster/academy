(ns academy.training-day-test
  (:require [clojure.test :refer :all]
            [academy.training-day :refer :all]))

(deftest training-day
  (is (= 42 answer))
  (is (= 9 (square 3)))
  (is (= 4 (square 2)))
  (is (= 3 (average 2 4)))
  (is (= 3/2 (average 1 2))))
