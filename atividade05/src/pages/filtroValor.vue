<template>
   <div class="filter2">
      <router-link to="/">----BACK---</router-link>

      Buscar valores entre: <input type="number" name="marca" v-model="valor[0]"><br>
      e <input type="number" name="marca" v-model="valor[1]"><br><br>

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
                <tr v-for="fun in funsF" :key="fun.id">
                    <th>{{fun.id}}</th>
                    <th>{{fun.endereco}}</th>
                    <th>{{fun.especialidade}}</th>
                    <th>{{fun.vagas}}</th>
                    <th>{{fun.valor}}</th>
                    <th>{{fun.data}}</th>
                </tr>
            </tbody>
        </table>

      <button @click="fetchFunByValores">Buscar</button>
  </div>
</template>

<script>
export default {
    data(){
        return {
            valor: [0,0],
            funs: [],
            funsF: [],
            baseURI: "http://localhost:8080/api/medicos"
        };
    },
    methods:{
        fetchFunByValores: function(){
            this.$http.get(this.baseURI + "/searchValores?valores=" + this.valor).then((result) => {
                this.funs = result.data;
                console.log(this.funs);
            }).catch(function(error){
                console.log(error);
                
            })

            for(let i = 0; i < this.funs.length;i++) {
                    if(this.funs[i].valor >=  this.valor[0]) {
                        if(this.funs[i].valor <= this.valor[1]){
                            this.funsF[i] = this.funs[i];
                    }     
                }
            }
        }
     }
}
</script>

<style>

</style>
