(ns sql-server.crud.delete
  (:require [clojure.java.jdbc :as jdbc]
            [honeysql.format :as honey]
            [sql-server.components.db :as db]))



(defn delete-user! [id]
  ; This function performs a delete operation on the "user" table using JDBC.
  ; It uses the provided database connection (db/db) and a SQL DELETE statement
  ; generated by the honey library, specifying the condition to delete the user
  ; with the given id from the "user" table.
  (jdbc/execute! db/db (honey/format {:delete-from :user
                                      :where [:= :id_user id]})))
