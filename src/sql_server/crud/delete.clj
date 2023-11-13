(ns sql-server.crud.delete
  (:require [clojure.java.jdbc :as jdbc]
            [honeysql.format :as honey]))

(honey/format {:delete [:order :item]
             :from [:order]
             :join [:item [:= :order.item-id :item.id]]
             :where [:= :item.id 42]})
(honey/format {
               :delete [:*]
               :from [:user]
               :where [:= :id 2]
})


(defn delete-user! [id]
  (honey/format 
   {:delete [:*]
    :from [:user]
    :where [:= :id id]})
  )