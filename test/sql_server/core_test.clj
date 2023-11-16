(ns sql-server.core-test
  (:require [clojure.test :refer :all]
            [sql-server.core :refer :all]
            [sql-server.crud.insert :as in]
            [sql-server.crud.search :as sc]))


(deftest  insert-test
  (testing "Testing the insert"
    (let [
          expected-result {
                           :id_user 2
                           :name "test_user"
                           :email "test_user@mail.com"
                           :address "test_user address"}
          transact (in/insert-user! "test_user" "test_user@mail.com" "test_user address")
          
          query (sc/get-user-id 2)
          _ (println (type query))
          _ (println (type expected-result))
          ]
       (is (= expected-result query)))
   ))



