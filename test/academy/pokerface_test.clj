(ns academy.pokerface-test
  (:require [clojure.test :refer :all]
            [academy.pokerface :refer :all]))

(deftest suit-test
  (is (= (suit "2H") "H"))
  (is (= (suit "2D") "D"))
  (is (= (suit "2C") "C"))
  (is (= (suit "3S") "S")))

(deftest rank-test
  (is (= (rank "2H") 2))
  (is (= (rank "4S") 4))
  (is (= (rank "TS") 10))
  (is (= (rank "JS") 11))
  (is (= (rank "QS") 12))
  (is (= (rank "KS") 13))
  (is (= (rank "AS") 14)))

(def high-seven ["2H" "3S" "4C" "5C" "7D"])

(def pair-hand ["2H" "2S" "4C" "5C" "7D"])

(def pair-hands #{["2H" "2S" "4C" "5C" "7D"]
                  ["2S" "4S" "4C" "9D" "KS"]})

(def two-pairs-hand ["2H" "2S" "4C" "4D" "7D"])

(def three-of-a-kind-hand ["2H" "2S" "2C" "4D" "7D"])

(def four-of-a-kind-hand ["2H" "2S" "2C" "2D" "7D"])

(def straight-hand ["2H" "3S" "6C" "5D" "4D"])

(def low-ace-straight-hand ["2H" "3S" "4C" "5D" "AD"])
(def high-ace-straight-hand ["TH" "AS" "QC" "KD" "JD"])
(def flush-hand ["2H" "4H" "5H" "9H" "7H"])
(def full-house-hand ["2H" "5D" "2D" "2C" "5S"])
(def straight-flush-hand ["2H" "3H" "6H" "5H" "4H"])
(def low-ace-straight-flush-hand ["2D" "3D" "4D" "5D" "AD"])
(def high-ace-straight-flush-hand ["TS" "AS" "QS" "KS" "JS"])

(deftest pair?-test
  (is (every? pair? pair-hands)) 
  (is (not (pair? high-seven))))

(deftest three-of-a-kind?-test
  (is (three-of-a-kind? three-of-a-kind-hand))
  (is (not (three-of-a-kind? two-pairs-hand))))

(deftest four-of-a-kind?-test
  (is (four-of-a-kind? four-of-a-kind-hand))
  (is (not (four-of-a-kind? two-pairs-hand))))

(deftest flush?-test
  (is (not (flush? pair-hand)))
  (is (flush? flush-hand)))

(deftest full-house?-test
  (is (not (full-house? three-of-a-kind-hand)))
  (is (not (full-house? four-of-a-kind-hand)))
  (is (full-house? full-house-hand)))

(deftest two-pairs?-test
  (is (two-pairs? two-pairs-hand))
  (is (not (two-pairs? three-of-a-kind-hand)))
  (is (not (two-pairs? pair-hand))))


(deftest straight?-test)
(is (not (straight? two-pairs-hand)))
(is (straight? straight-hand))
(is (straight? low-ace-straight-hand))
(is (not (straight? ["2H" "2D" "3H" "4H" "5H"])))
(is (not (straight? ["2H" "3H" "3D" "4H" "6H"])))
(is (straight? high-ace-straight-hand))

(deftest straight-flush?-test
  (is (not (straight-flush? straight-hand)))
  (is (not (straight-flush? flush-hand)))
  (is (straight-flush? straight-flush-hand))
  (is (straight-flush? low-ace-straight-flush-hand))
  (is (straight-flush? high-ace-straight-flush-hand)) )

(deftest value-test
  (is (every? (partial = 1) (map value pair-hands)))
  (is (= (value high-seven) 0))
  (is (= (value two-pairs-hand) 2))
  (is (= (value three-of-a-kind-hand) 3))
  (is (= (value straight-hand) 4))
  (is (= (value flush-hand) 5))
  (is (= (value full-house-hand) 6))
  (is (= (value four-of-a-kind-hand) 7))
  (is (= (value straight-flush-hand) 8)))