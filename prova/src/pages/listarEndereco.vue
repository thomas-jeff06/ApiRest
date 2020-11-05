<template>
   <div class="filter1">
      <router-link to="/">----BACK---</router-link>

      Buscar pelo endereço: <input type="text" name="marca" v-model="endereco"><br><br>

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
            <div class="er">
                <li v-for="error in errors" :key="error.id">
                    {{erros.id}}
                </li>
            </div>

      <button @click="fetchFunByEndereco">Buscar</button>
  </div>
</template>

<script>
export default {
    data(){
        return {
            endereco: '',
            funs: [],
            errors: [],
            baseURI: "http://localhost:8080/api/medicos"
        };
    },
    methods:{
        fetchFunByEndereco: function(){
            this.$http.get(this.baseURI + "/searchEndereco?endereco=" + this.endereco).then((result) => {
                this.funs = result.data;
                console.log(this.funs);
            }).catch(function(error){
                console.log(error);
                this.errors.push(" não encontrado");
            })
        }
    }

}
</script>

<style>

</style>
