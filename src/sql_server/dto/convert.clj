(ns sql-server.dto.convert)

(defn user->dto
  ; Converts a user entity to a Data Transfer Object (DTO).
  [user]
  {:user/id (-> user :id_user)
   :user/name (-> user :name)
   :user/email (-> user :email)
   :user/address (-> user :address)})

(defn dto->user
  ; Converts a Data Transfer Object (DTO) to a user entity.
  [dto]
  {:id_user (-> dto :user/id)
   :name (-> dto :user/name)
   :email (-> dto :user/email)
   :address (-> dto :user/address)})