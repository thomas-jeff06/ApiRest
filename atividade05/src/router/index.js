import Vue from 'vue';
import VueRouter from 'vue-router'

import Home from '../pages/home.vue'

import Listagem from '../pages/Listagem.vue';
import Cadastro from '../pages/cadastro.vue';
import Filtros from '../pages/filtros.vue';
import FiltroValor from '../pages/filtroValor.vue';
import ListarData from '../pages/listarData.vue'
import ListarEndereco from '../pages/listarEndereco.vue';
import ListarQTD from '../pages/listarQTD.vue'
import ListarValor from '../pages/listarValor.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home
  },
  {
    path: '/listagem',
    name:'listagem',
    component:Listagem
  }, {
    path: '/cadastro',
    name: 'Cadastro',
    component: Cadastro
  }, {
    path: '/filtros',
    name: 'filtro',
    component: Filtros
  }, {
    path: '/filtroValor',
    name: 'valot',
    component: FiltroValor
  }, {
    path: '/listarData',
    name: 'data',
    component: ListarData
  }, {
    path: '/listarEndereco',
    name: 'endereco',
    component: ListarEndereco
    }, {
    path: '/listarQTD',
    name: 'QTD',
    component: ListarQTD
  },  {
    path: '/listarValor',
    name: 'valor',
    component: ListarValor
  },
  {
    path:'*',
    redirect:'/'
  },
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
