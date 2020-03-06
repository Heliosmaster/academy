(ns academy.recursion-test
  (:require [clojure.test :refer :all]
            [academy.recursion :refer :all]))

(defn empty? [x]
  (and (sequential? x)
       (clojure.core/empty? x)))

(deftest product-test
  (is (= (product []) 1))
  (is (= (product [1 2 3]) 6))
  (is (= (product [1 2 3 4]) 24))
  (is (= (product [0 1 2]) 0))
  (is (= (product #{2 3 4}) 24)))

(deftest singleton?-test
  (is (singleton? [1]))
  (is (singleton? #{2}))
  (is (singleton? [nil]))
  (is (not (singleton? [1 nil])))
  (is (not (singleton? [])))
  (is (not (singleton? [1 2 3]))))

(deftest my-last-test
  (is (nil? (my-last [])))
  (is (= (my-last [1 2 3]) 3))
  (is (= (my-last [2 5]) 5)))

(deftest max-element-test
  (is (= (max-element [2 4 1 4]) 4))
  (is (= (max-element [2]) 2))
  (is (= (max-element []) nil)))

(deftest seq-max-test
  (is (= (seq-max [1] [1 2]) [1 2]))
  (is (= (seq-max [1 2 3] [:a :b]) [1 2 3]))
  (is (= (seq-max [1 2] [3 4]) [3 4])))

(deftest longest-sequence-test
  (is (= (longest-sequence [[1 2] [] [1 2 3]]) [1 2 3]))
  (is (= (longest-sequence [[1 2]]) [1 2]))
  (is (= (longest-sequence []) nil)))

(deftest my-filter-test
  (is (= (set (my-filter odd? [1 2 3 4])) #{1 3}))
  (is (empty? (my-filter false? [1 2 3])))
  (is (= (set (my-filter nil? [1 nil 2]))
         #{nil}))
  (is (= (set (my-filter (fn [x] (> x 9000)) [12 49 90 9001])) #{9001}))
  (is (empty? (my-filter even? [1 3 5 7]))))

(deftest sequence-contains?-test
  (is (sequence-contains? 3 [1 2 3]))
  (is (not (sequence-contains? 3 [4 7 9])))
  (is (not (sequence-contains? :pony []))))

(deftest my-take-while-test
  (is (= (my-take-while odd? [1 2 3 4]) '(1)))
  (is (= (my-take-while odd? [1 3 4 5]) '(1 3)))
  (is (empty? (my-take-while even? [1 3 4 5])))
  (is (empty? (my-take-while odd? []))))

(deftest my-drop-while-test
  (is (= (my-drop-while odd? [1 2 3 4]) '(2 3 4)))
  (is (= (my-drop-while odd? [1 3 4 5]) '(4 5)))
  (is (= (my-drop-while even? [1 3 4 5]) '(1 3 4 5)))
  (is (empty? (my-drop-while odd? []))))

(deftest seq=-test
  (is (seq= [1 2 4] '(1 2 4)))
  (is (seq= [] []))
  (is (not (seq= [1 2 nil] [1 2])))
  (is (not (seq= [1 4 2] [1 2 4])))
  (is (not (seq= [1 2 3] [1 2 3 4])))
  (is (not (seq= [1 3 5] []))))

(deftest my-map-test
  (is (= (my-map + [1 2 3] [4 4 4]) '(5 6 7)))
  (is (= (my-map + [1 2 3 4] [0 0 0]) '(1 2 3)))
  (is (empty? (my-map + [1 2 3] []))))

(deftest power-test
  (is (= (power 2 2) 4))
  (is (= (power 5 3) 125))
  (is (= (power 7 0) 1))
  (is (= (power 0 10) 0)))

(deftest fib-test
  (is (= (fib 0) 0))
  (is (= (fib 1) 1))
  (is (= (fib 2) 1))
  (is (= (fib 3) 2))
  (is (= (fib 4) 3))
  (is (= (fib 5) 5))
  (is (= (fib 6) 8))
  (is (= (fib 10) 55)))

(deftest my-repeat-test
  (is (= (my-repeat 2 :a) '(:a :a)))
  (is (= (my-repeat 3 "lol") '("lol" "lol" "lol")))
  (is (empty? (my-repeat -1 :a))))

(deftest my-range-test
  (is (empty? (my-range 0)))
  (is (= (my-range 1) '(0)))
  (is (= (my-range 2) '(1 0)))
  (is (= (my-range 3) '(2 1 0))))


(deftest tails-test
  (is (= (set (tails [1 2 3 4])))) #{[1 2 3 4] [2 3 4] [3 4] [4] []}
  (is (set (tails [])) #{[]})
  (is (set (tails [1])) #{[1] []}))

(deftest "inits"
  (is (= (set (inits [1 2 3 4])))
      #{[] [1] [1 2] [1 2 3] [1 2 3 4]}))
(is (= (set (inits []))
       #{[]}))
(is (= (set (inits [1]))
       #{[] [1]}))

(deftest rotations-test
  (is (= (rotations []) '()))
  (is (= (set (rotations [1 2 3])))) #{[1 2 3] [2 3 1] [3 1 2]}
  (is (= (set (rotations [:a :b])))) #{[:a :b] [:b :a]}
  (is (= (set (rotations [1 5 9 2])))) #{'(1 5 9 2) '(2 1 5 9) '(9 2 1 5) '(5 9 2 1)}
  (is (= 5 (count (rotations [6 5 8 9 2])))))

(deftest my-frequencies-test
  (is (= (my-frequencies []) {}))
  (is (= (my-frequencies [1 1 2 2 :D :D :D]) {1 2, 2 2, :D 3}))
  (is (= (my-frequencies [:a "moi" :a "moi" "moi" :a 1]) {:a 3, "moi" 3, 1 1})))

(deftest un-frequencies-test
  (let [r (un-frequencies {:a 3 :b 2 "^_^" 1})]
    (is (= 3 (count (filter #(= :a %) r))))
    (is (= 2 (count (filter #(= :b %) r))))
    (is (= 1 (count (filter #(= "^_^" %) r)))))
  (let [r (un-frequencies (my-frequencies [:a :b :c :a]))]
    (is (= 2 (count (filter #(= :a %) r))))
    (is (= 1 (count (filter #(= :b %) r))))
    (is (= 1 (count (filter #(= :c %) r)))))
  (is (= (my-frequencies (un-frequencies {:a 100 :b 10}))
         {:a 100 :b 10})))

(deftest my-take-test
  (is (= (my-take 2 [1 2 3 4]) '(1 2)))
  (is (= (my-take 4 [:a :b]) '(:a :b))))

(deftest my-drop-test
  (is (= (my-drop 2 [1 2 3 4]) '(3 4)))
  (is (empty? (my-drop 4 [:a :b]))))

(deftest halve-test
  (is (= (halve [1 2 3 4]) ['(1 2) '(3 4)]))
  (is (= (halve [1 2 3 4 5]) ['(1 2) '(3 4 5)]))
  (is (= (halve [1]) ['() '(1)])))

(deftest seq-merge-test
  (is (= (seq-merge [4] [1 2 6 7]) '(1 2 4 6 7)))
  (is (= (seq-merge [1 5 7 9] [2 2 8 10]) '(1 2 2 5 7 8 9 10))))

(deftest merge-sort-test
  (is (empty? (merge-sort [])))
  (is (= (merge-sort [1 2 3]) '(1 2 3)))
  (is (= (merge-sort [5 3 4 17 2 100 1]) '(1 2 3 4 5 17 100))))

(deftest split-into-monotonics
  (is (= (split-into-monotonics [0 1 2 1 0]) '((0 1 2) (1 0))))
  (is (= (split-into-monotonics [0 5 4 7 1 3]) '((0 5) (4 7) (1 3)))))

(deftest permutations-test
  (is (empty? (permutations [])))
  (is (= (count (permutations (range 5))) 120))
  (is (= (set (permutations [1 5 3]))
         #{[1 5 3] [5 1 3] [5 3 1] [1 3 5] [3 1 5] [3 5 1]})))

(deftest powerset-test
  (is (= (powerset []) #{#{}}))
  (is (= (powerset #{1 2 4})
         #{#{} #{4} #{2} #{2 4} #{1} #{1 4} #{1 2} #{1 2 4}}))
  (is (= (count (powerset (range 10)))
         1024)))
