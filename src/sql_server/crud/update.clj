(ns sql-server.crud.update
  (:require [clojure.java.jdbc :as jdbc]
            [sql-server.components.db :as db]
            [honeysql.format :as honey]))

#_(honey/format {:update :user
             :set {:name name}
             :where [:= :id 2]})


(defn update-user! [id name]
  (jdbc/execute! db/db (honey/format {
                                    :update :user
                                    :set {:name name}
                                    :where [:= :id_user id]  
  })))

