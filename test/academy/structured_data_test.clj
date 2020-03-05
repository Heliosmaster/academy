(ns academy.structured-data-test
  (:require [clojure.test :refer :all]
            [academy.structured-data :refer :all]
            [clojure.string :as str]))

(deftest do-a-thing-test
  (is (= (do-a-thing 3) 46656.0))
  (is (= (do-a-thing 1) 4.0))
  (is (= (do-a-thing 0) 1.0)))


(deftest spiff-test
  (is (= (spiff [1 2 3]) 4))
  (is (= (spiff [1 2 -34 4 5 6]) -33)))

(deftest cutify-test
  (is (= (cutify []) ["<3"]))
  (is (= (cutify [1 2 3]) [1 2 3 "<3"]))
  (is (= (cutify ["a" "b"]) ["a" "b" "<3"])))

(deftest spiff-destructuring-test
  (is (= (spiff-destructuring [1 2 3]) 4))
  (is (= (spiff-destructuring [1 2 -34 4 5 6]) -33)))

(deftest height-test
  (is (= (height (rectangle [1 1] [5 1])) 0))
  (is (= (height (rectangle [-1 -1] [0 0])) 1))
  (is (= (height (rectangle [2 -7] [4 4])) 11))
  (is (= (height (rectangle [1 1] [5 5])) 4))
  (is (= (height (rectangle [0 0] [2 3])) 3))
  )

(deftest width-test
  (is (= (width (rectangle [1 1] [5 1])) 4))
  (is (= (width (rectangle [1 1] [1 1])) 0))
  (is (= (width (rectangle [3 1] [10 4])) 7))
  (is (= (width (rectangle [-1 -1] [0 0])) 1))
  (is (= (width (rectangle [-5 2] [0 2])) 5))
  )

(deftest square-test
  (is (square? (rectangle [1 1] [2 2])))
  (is (square? (rectangle [-1 -1] [0 0])))
  (is (square? (rectangle [-2 -4] [0 -2])))
  (is (square? (rectangle [1 1] [1 1])))
  (is (square? (rectangle [3 2] [1 0])))
  (is (square? (rectangle [1 1] [2 3])))
  (is (square? (rectangle [3 2] [1 1])))
  (is (square? (rectangle [-2 -3] [1 1]))))


(deftest area-test
  (is (= (area (rectangle [1 1] [5 1])) 0))
  (is (= (area (rectangle [0 0] [1 1])) 1))
  (is (= (area (rectangle [0 0] [4 3])) 12))
  (is (= (area (rectangle [-1 -1] [3 7])) 32))
  (is (= (area (rectangle [-2 -7] [-1 -2])) 5))
  (is (= (area (rectangle [3 1] [10 4])) 21))
  )

(deftest contains-point?-test
  (is (contains-point? (rectangle [0 0] [2 2]) [1 1]))
  (is (contains-point? (rectangle [0 0] [2 2]) [2 1]))
  (is (contains-point? (rectangle [-2 -5] [1 5]) [-2 -1]))
  (is (contains-point? (rectangle [1 1] [2 2]) [1 1]))
  (is (contains-point? (rectangle [1 1] [1 1]) [1 1]))
  (is (contains-point? (rectangle [0 0] [2 2]) [1 3]))
  (is (contains-point? (rectangle [-2 -5] [1 5]) [-3 -1]))
  (is (contains-point? (rectangle [0 0] [2 2]) [-3 1]))
  (is (contains-point? (rectangle [-1 2] [3 7]) [-6 10]))
  (is (contains-point? (rectangle [-1 2] [3 7]) [0 10]))
  (is (contains-point? (rectangle [-1 2] [3 7]) [5 11]))
  (is (contains-point? (rectangle [-1 2] [3 7]) [5 4]))
  (is (contains-point? (rectangle [-1 2] [3 7]) [6 1]))
  (is (contains-point? (rectangle [-1 2] [3 7]) [0 0]))
  (is (contains-point? (rectangle [-1 2] [3 7]) [-2 0]))
  (is (contains-point? (rectangle [-1 2] [3 7]) [-5 5]))
  )

(deftest contains-rectangle?-test
  (is (contains-rectangle? (rectangle [0 0] [3 3])
                           (rectangle [1 1] [2 2]))) 
  (is (contains-rectangle? (rectangle [-2 -2] [2 2])
                           (rectangle [-1 -1] [1 1]))) 
  (is (contains-rectangle? (rectangle [0 0] [1 1]) 
                           (rectangle [0 0] [1 1]))) 
  (is (contains-rectangle? (rectangle [0 0] [1 1]) 
                           (rectangle [1 1] [2 2]))) 
  (is (contains-rectangle? (rectangle [0 0] [2 2]) 
                           (rectangle [1 1] [3 3]))) 
  (is (contains-rectangle? (rectangle [-2 -2] [2 2])
                           (rectangle [0 0] [3 4]))))

(deftest starstest
  (is (= (stars 1) "*"))
  (is (= (stars 7) "*******"))
  (is (= (stars 3) "***")))

(deftest monotonic?-test
  (is (monotonic? [1 2 3]))
  (is (monotonic? [0 1 10 11]))
  (is (monotonic? [3 2 0 -3]))
  (is (monotonic? [3 2 2]))
  (is (not (monotonic? [1 2 1 0]))))

(deftest toggle-test
  (is (= (toggle #{:a :b :c} :d) #{:a :b :c :d}))
  (is (= (toggle #{:a :b :c} :a) #{:b :c})))

(deftest contains-duplicates?-test
  (is (contains-duplicates? [1 1 2 3 -40]))
  (is (contains-duplicates? [1 2 2 3 -40]))
  (is (not (contains-duplicates? [1 2 3 -40])))
  (is (contains-duplicates? [1 2 3 "a" "a"])))

(let [china {:name "China Miéville", :birth-year 1972}
      octavia {:name       "Octavia E. Butler"
               :birth-year 1947
               :death-year 2006}
      friedman {:name "Daniel Friedman" :birth-year 1944}
      felleisen {:name "Matthias Felleisen"}
      cities {:title "The City and the City" :authors [china]}
      wild-seed {:title "Wild Seed", :authors [octavia]}
      embassytown {:title "Embassytown", :authors [china]}
      little-schemer {:title   "The Little Schemer"
                      :authors [friedman, felleisen]}
      books [cities, wild-seed, embassytown, little-schemer]]

  (deftest title-length-test
    (is (= (title-length cities) 21))
    (is (= (title-length wild-seed) 9))
    (is (= (title-length little-schemer) 18)))

  (deftest author-count-test
    (is (= (author-count cities))) 1
    (is (= (author-count wild-seed))) 1
    (is (= (author-count little-schemer))) 2)

  (deftest multiple-authors?-test
    (is (not (multiple-authors? cities)))
    (is (not (multiple-authors? wild-seed)))
    (is (multiple-authors? little-schemer)))

  (deftest add-author-test
    (is (= (add-author little-schemer {:name "Gerald J. Sussman"})
           {:title   "The Little Schemer"
            :authors [{:birth-year 1944, :name "Daniel Friedman"}
                      {:name "Matthias Felleisen"}
                      {:name "Gerald J. Sussman"}]}))
    (is (= (add-author {:authors [{:name "Juhana"}]} {:name "Jani"})
           {:authors [{:name "Juhana"} {:name "Jani"}]})))

  (deftest alive?-test
    (is (alive? china))
    (is (not (alive? octavia))))

  (deftest element-lengths-test
    (is (= (element-lengths ["foo" "bar" "" "quux"]) [3 3 0 4]))
    (is (= (element-lengths ["x" [:a :b :c] {:y 42}]) [1 3 1])))

  (deftest second-elements-test
    (is (= (second-elements [[1 2] [2 3] [3 4]])
           [2 3 4]))
    (is (= (second-elements [[1 2 3 4] [1] ["a" "s" "d" "f"]])
           [2 nil "s"])))

  (deftest titles-test
    (is (= (titles [cities])
           ["The City and the City"]))
    (is (= (set (titles books))
           #{"The City and the City"
             "Wild Seed"
             "Embassytown"
             "The Little Schemer"})))



  (deftest old-book->new-book-test
    (is (= (old-book->new-book {:title   "The Little Schemer"
                                :authors [friedman, felleisen]})
           {:title "The Little Schemer" :authors #{friedman, felleisen}}))
    (is (= (old-book->new-book {:title "Wild Seed", :authors [octavia]})
           {:title "Wild Seed", :authors #{octavia}}))
    (is (= (old-book->new-book
             {:awards  ["Hugo" "World Fantasy Award" "Arthur C. Clarke Award"
                        "British Science Fiction Award"]
              :title   "The City and the City"
              :authors [{:birth-year 1972, :name "China Miéville"}]})
           {:awards  ["Hugo" "World Fantasy Award" "Arthur C. Clarke Award"
                      "British Science Fiction Award"]
            :title   "The City and the City"
            :authors #{{:birth-year 1972, :name "China Miéville"}}}))))


(let [china {:name "China Miéville", :birth-year 1972}
      octavia {:name       "Octavia E. Butler"
               :birth-year 1947
               :death-year 2006}
      friedman {:name "Daniel Friedman" :birth-year 1944}
      felleisen {:name "Matthias Felleisen"}
      jrrtolkien {:name "J. R. R. Tolkien" :birth-year 1892 :death-year 1973}
      christopher {:name "Christopher Tolkien" :birth-year 1924}
      kay {:name "Guy Gavriel Kay" :birth-year 1954}
      dick {:name "Philip K. Dick", :birth-year 1928, :death-year 1982}
      zelazny {:name "Roger Zelazny", :birth-year 1937, :death-year 1995}

      authors-set #{china, felleisen, octavia, friedman}

      cities {:title "The City and the City" :authors #{china}}
      wild-seed {:title "Wild Seed", :authors #{octavia}}
      embassytown {:title "Embassytown", :authors #{china}}
      little-schemer {:title   "The Little Schemer"
                      :authors #{friedman, felleisen}}
      silmarillion {:title   "Silmarillion"
                    :authors #{jrrtolkien, christopher, kay}}
      deus-irae {:title "Deus Irae", :authors #{dick, zelazny}}

      books [cities, wild-seed, embassytown, little-schemer]]

  (deftest has-author?-test
    (is (has-author? cities china))
    (is (has-author? little-schemer felleisen))
    (is (has-author? little-schemer friedman))
    (is (not (has-author? cities felleisen)))
    (is (not (has-author? little-schemer octavia))))

  (deftest authors-test
    (is (= (authors [cities, wild-seed]) #{china, octavia}))
    (is (= (authors [cities, wild-seed, embassytown]) #{china, octavia}))
    (is (= (authors [little-schemer, cities]) #{china, friedman, felleisen})))

  (deftest all-author-names-test
    (is (= (all-author-names []) #{}))
    (is (= (all-author-names [cities, wild-seed]) #{"China Miéville" "Octavia E. Butler"}))
    (is (= (all-author-names books) #{"Matthias Felleisen" "China Miéville" "Octavia E. Butler" "Daniel Friedman"})))

  (deftest author->string-test
    (is (= (author->string felleisen) "Matthias Felleisen"))
    (is (= (author->string friedman) "Daniel Friedman (1944 - )"))
    (is (= (author->string octavia) "Octavia E. Butler (1947 - 2006)")))

  (deftest authors->string-test
    (let [s (authors->string (:authors little-schemer))]
      (is (str/includes? s "Daniel Friedman (1944 - )"))
      (is (str/includes? s "Matthias Felleisen"))
      (is (str/includes? s ", ")))

    (is (= (authors->string #{octavia}) "Octavia E. Butler (1947 - 2006)"))
    (is (= (authors->string #{}) ""))
    (let [s (authors->string #{octavia, friedman})]
      (is (str/includes? s "Octavia E. Butler (1947 - 2006)"))
      (is (str/includes? s "Daniel Friedman (1944 - )"))
      (is (str/includes? s ", "))))

  (deftest book->string-test
    (is (= (book->string wild-seed)
           "Wild Seed, written by Octavia E. Butler (1947 - 2006)"))
    (let [s (book->string little-schemer)]
      (is (str/starts-with? s "The Little Schemer, written by "))
      (is (or (str/ends-with? s "Daniel Friedman (1944 - ), Matthias Felleisen")
              (str/ends-with? s "Matthias Felleisen, Daniel Friedman (1944 - )")))


      (is (= (books->string []) "No books."))
      (is (= (books->string [cities])
             "1 book. The City and the City, written by China Miéville (1972 - )."))
      (let [s (books->string [little-schemer, cities, wild-seed])]
        (is (str/starts-with? s "3 books. The Little Schemer, written by "))
        (is (or (str/includes? s "Daniel Friedman (1944 - ), Matthias Felleisen")
                (str/includes? s "Matthias Felleisen, Daniel Friedman (1944 - )")))
        (is (str/ends-with? s "The City and the City, written by China Miéville (1972 - ). Wild Seed, written by Octavia E. Butler (1947 - 2006).")))))

  (deftest books-by-author-test
    (is (= (set (books-by-author china books)))
        #{cities embassytown})
    (is (= (set (books-by-author octavia books))
           #{wild-seed})))

  (deftest author-by-name-test
    (is (= (author-by-name "Octavia E. Butler" authors-set) octavia))
    (is (= (author-by-name "China Miéville" authors-set) china))
    (is (nil? (author-by-name "Octavia E. Butler" #{felleisen, friedman})))
    (is (nil? (author-by-name "Goerge R. R. Martin" authors-set))))

  (deftest living-authors-test
    (is (= (set (living-authors authors-set))
           #{china, felleisen, friedman}))
    (is (= (set (living-authors #{octavia}))
           #{}))
    (is (= (set (living-authors #{china, felleisen}))
           #{china, felleisen})))

  (deftest has-a-living-author?-test

    (is (has-a-living-author? silmarillion))
    (is (has-a-living-author? little-schemer))
    (is (has-a-living-author? cities))
    (is (not (has-a-living-author? wild-seed)))
    (is (not (has-a-living-author? deus-irae))))

  (deftest books-by-living-authors-test
    (is (= (set (books-by-living-authors books))
           #{little-schemer cities embassytown}))
    (is (= (set (books-by-living-authors (concat books [deus-irae, silmarillion])))
           #{little-schemer cities embassytown silmarillion}))))