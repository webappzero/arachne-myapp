(require '[arachne.core.dsl :as core])

(core/runtime :myapp/runtime [:myapp/ticktock])

(core/component :myapp/ticktock {}
  'myapp.ticktock/->TickTock)
