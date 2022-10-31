(ns modulo-3.interceptors
  (:require [io.pedestal.interceptor :as i]
            [modulo-3.logic :as l]))

(def all-points-interceptor
  (i/interceptor {:name  :all-points-interceptor
                  :enter (fn [context]
                           (let [db (:db context)]
                             (assoc context :response {:status 200
                                                       :body (l/all-points @db)})))}))

(def all-points-interceptor
  (i/interceptor {:name  :all-points-interceptor
                  :enter (fn [context]
                           (let [db (:db context)]
                             (assoc context :response {:status 200
                                                       :body (l/all-points @db)})))}))

;1 interceptor de autorizacao
;verificar se a request vem com o header key
;e fazer o bind de :user na request caso exista, caso contrario erro 400
(def interceptor-autorizacao
  (i/interceptor
    {:name  ::autorizacao
     :enter (funcao-autorizacao)}))

(defn funcao-autorizacao [context]
  (let [term (get-in context [:request :query-params :term])]
    (println term)
    )
  )