<template>
  <div class="del">
      <router-link to="/">----BACK---</router-link>
       Selecione a data: <input type="date" name="id" v-model="data">

        <table class="table">
            <thead>
                <tr>
                    <th>id</th>
                    <th>endereço</th>
                    <th>Especialidade</th>
                    <th>vagas</th>
                    <th>valor</th>
                    <th>data de Formação</th>
                </tr>
            </thead>
            <tbody>
                <tr v-for="fun in funs" :key="fun.id">
                    <th>{{fun.id}}</th>
                    <th>{{fun.endereco}}</th>
                    <th>{{fun.especialidade}}</th>
                    <th>{{fun.vagas}}</th>
                    <th>{{fun.valor}}</th>
                    <th>{{fun.data}}</th>
                </tr>
            </tbody>
        </table>

        <button @click="buscarData"> buscar</button>
  </div>
</template>

<script>
export default {
      data(){
        return {
          data:'',
          funs: [],
          baseURI: "http://localhost:8080/api/medicos"
        };
    },
    methods:{
        buscarData: function(){
            this.$http.get(this.baseURI + "/searchData?data=" + this.data).then((result) => {
                this.funs = result.data;
            }).catch(function(error){
                console.log(error);
            })
        }
    }
}
</script>

<style>

</style>