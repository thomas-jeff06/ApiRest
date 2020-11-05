<template>
    <div class="home">
    <div id="nav">
        <router-link to="/cadastro"> cadastrar |</router-link>
        <router-link to="/listagem"> listar todos|</router-link>
        <router-link to="/listarQTD"> listar pela quantidade de medicos |</router-link>
        <router-link to="/listarEndereco"> listar pelo endereço |</router-link>
        <router-link to="/listarData"> listar, mes e ano|</router-link>
        <router-link to="/listarValor">listar pelo valor de consulta |</router-link>
        <router-link to="/filtroValor"> filtrar pelo valor de consulta |</router-link>
        <router-link to="/filtros"> filtrar por quantidade de vagas e especialidade|</router-link>
    </div>
    <router-view />
  </div>
</template>

<script>
export default {

}
</script>

<style>

</style>