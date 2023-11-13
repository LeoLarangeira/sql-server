(ns sql-server.crud.search
  (:require [sql-server.components.db :as db]
            [honeysql.format :as honey]
            [clojure.java.jdbc :as jdbc]
            [cheshire.core :refer :all]
            [honeysql.core :as sql]))


(defn get-five-users []
  
  (let [query '{:select [:*], :from [:user], :limit :5}
        result (jdbc/query db/db (honey/format query))
        _ (println result)
        string-body (generate-string (str result))
        _ (println string-body)]
    
    {
     :status 200 
     :headers  {"Content-Type" "application/json; charset=utf-8"}
     :body result
    }
    )
  )

(honey/format {
               :select [:*] :from [:user] :where [:= :id 2]
})
(defn get-user-id [id]
  (let [result (jdbc/query db/db (honey/format {:select [:*] :from [:user] :where [:= :id id]}))]
    (generate-string result)))