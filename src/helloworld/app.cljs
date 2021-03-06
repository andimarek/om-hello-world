(ns helloworld.app
  (:require-macros [cljs.core.async.macros :refer [go]]
                   [secretary.macros :refer [defroute]])
  (:require [goog.events :as events]
            [cljs.core.async :refer [put! <! chan]]
            [om.core :as om :include-macros true]
            [om.dom :as dom :include-macros true]
            [secretary.core :as secretary]
            [clojure.string :as string]
            [clojure.browser.repl])
  (:import [goog History]
           [goog.history EventType]))

(defn widget [data owner]
  (reify
    om/IRender
    (render [this]
      (dom/h1 nil (dom/span nil (:text data))))))

(om/root widget {:text "Hello world2!"}
  {:target (. js/document (getElementById "app"))})

(defn whoami
  []
  (.-userAgent js/navigator))
