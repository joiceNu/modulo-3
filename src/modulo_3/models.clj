(ns modulo-3.models
  (:require [schema.core :as s]))


;;Sugestão Plumatic schema
;;However, we encourage you to use s/defschema for this purpose to improve error messages:

(s/defschema PosInt (s/pred pos-int?))

(s/defschema EnumStatus (s/enum :desativada :conserto :alugada :no-ponto))

(s/defschema Address
  {:street       s/Str
   :number       s/Str
   :zip-code     s/Str
   :address-line s/Str})

(s/defschema Point
  {:name     s/Str
   :capacity s/Num
   :address  Address})

(def User {:login                s/Str
           (s/optional-key :key) s/Str})

(def Points {s/Keyword Point})

(s/defschema Bike {
                   :data-aquisicao s/Str
                   })

(s/defschema Bike-List
  { PosInt Bike})

(def Bike-historico { :id-bike :1
                     :data-hora-status s/Str
                     :status EnumStatus
                     (s/optional-key :point) PosInt
                     (s/optional-key :user)  PosInt
                     :ativo s/Bool
                     })

(s/defschema Bike-historico
  { PosInt Bike})



(def Database
  {:points {PosInt Point}
   :bikes  {PosInt Bike}
   :bike-historico  {Bike-historico}
   :users  {PosInt User}})
