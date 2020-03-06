(ns academy.predicates-test
  (:require [clojure.test :refer :all]
            [academy.predicates :refer :all]))



(deftest sum-f-test
  (is (= (sum-f inc dec 4) 8))
  (is (= (sum-f inc identity 5) 11))
  (is (= (sum-f identity - 10) 0)))

(deftest less-than-test
  (is (= (filter (less-than 3) [1 2 3 4 5])
         [1 2]))
  (is (= (filter (less-than 4) [-2 12 3 4 0])
         [-2 3 0])))

(deftest equal-to-test
  (is (= (filter (equal-to 2) [2 1 3 2.0]) [2 2.0]))
  (is (= (filter (equal-to 2) [3 4 5 6]) [])))

(deftest set->predicate-test
  (is (= (filter (set->predicate #{1 2 3}) [0 2 4 6]) [2]))
  (is (= (filter (set->predicate #{1 2 3 nil}) [2 nil 4 nil 6]) [2 nil nil])))

(deftest pred-and-test
  (is (= (filter (pred-and pos? even?) [1 2 -4 0 6 7 -3]) [2 6]))
  (is (= (filter (pred-and pos? odd?) [1 2 -4 0 6 7 -3]) [1 7]))
  (is (= (filter (pred-and (complement nil?) empty?) [[] '() nil {} #{}]) [[] '() {} #{}])))

(deftest pred-or-test
  (is (= (filter (pred-or pos? odd?) [1 2 -4 0 6 7 -3]) [1 2 6 7 -3]))
  (is (= (filter (pred-or pos? even?) [1 2 -4 0 6 7 -3]) [1 2 -4 0 6 7])))

(deftest blank?-test
  (is (blank? ""))
  (is (blank? " \t\n\t "))
  (is (not (blank? "  \t a"))))

(def awards #{:locus, :world-fantasy, :hugo})

(def china {:name "China Miéville", :birth-year 1972})
(def octavia {:name       "Octavia E. Butler"
              :birth-year 1947
              :death-year 2006})
(def kay {:name "Guy Gavriel Kay" :birth-year 1954})
(def dick {:name "Philip K. Dick", :birth-year 1928, :death-year 1982})
(def zelazny {:name "Roger Zelazny", :birth-year 1937, :death-year 1995})

(def authors #{china, octavia, kay, dick, zelazny})

(def cities {:title  "The City and the City" :authors #{china}
             :awards #{:locus, :world-fantasy, :hugo}})
(def wild-seed {:title "Wild Seed", :authors #{octavia}})
(def lord-of-light {:title  "Lord of Light", :authors #{zelazny}
                    :awards #{:hugo}})
(def deus-irae {:title "Deus Irae", :authors #{dick, zelazny}})
(def ysabel {:title "Ysabel", :authors #{kay}, :awards #{:world-fantasy}})
(def scanner-darkly {:title "A Scanner Darkly" :authors #{dick}})

(def books #{cities, wild-seed, lord-of-light,
             deus-irae, ysabel, scanner-darkly})

(deftest has-award?-test
  (is (has-award? ysabel :world-fantasy))
  (is (not (has-award? scanner-darkly :hugo))))

(deftest HAS-ALL-THE-AWARDS?-test
  (is (HAS-ALL-THE-AWARDS? cities #{:locus}))
  (is (HAS-ALL-THE-AWARDS? cities #{:locus :world-fantasy :hugo}))
  (is (HAS-ALL-THE-AWARDS? scanner-darkly #{}))
  (is (HAS-ALL-THE-AWARDS? lord-of-light #{:hugo}))
  (is (not (HAS-ALL-THE-AWARDS? cities #{:locus :world-fantasy :hugo :pulitzer})))
  (is (not (HAS-ALL-THE-AWARDS? lord-of-light #{:locus :world-fantasy :hugo}))))

(deftest my-some-test
  (is (not (my-some even? [1 3 5 7])))
  (is (my-some even? [1 3 5 7 8]))
  (is (my-some neg? [1 3 5 0 7 -1 8]))
  (is (= (my-some first [[false] [1]]) 1))
  (is (my-some nil? [1 nil 2]))
  (is (not (my-some neg? [1 3 5 0 7 8])))
  (is (not (my-some neg? [])))
  (is (not (my-some first [[false] []])))
  (is (not (my-some nil? [1 2]))))

(deftest my-every?-test
  (is (my-every? pos? [1 2 3 4]))
  (is (my-every? even? [2 4 6]))
  (is (my-every? even? []))
  (is (not (my-every? pos? [1 2 3 4 0]))))

(deftest prime?-test
  (is (prime? 7))
  (is (not (prime? 4)))
  (is (not (prime? 10)))
  (is (= (filter prime? (range 2 50)) [2 3 5 7 11 13 17 19 23 29 31 37 41 43 47])))

