(ns sql-server.dto.convert
  (:require [com.brunobonacci.mulog :as u]))

(defn user->dto [user]
  ; Converts a user entity to a Data Transfer Object (DTO).
  (let [name (get-in user [:user/name])
        email (get-in user [:user/email])
        address (get-in user [:user/address])]
    {:name name
     :email email
     :address address}))

(defn dto->user
  ; Converts a Data Transfer Object (DTO) to a user entity.
  [dto]
  {:name (-> dto :user/name)
   :email (-> dto :user/email)
   :address (-> dto :user/address)})
