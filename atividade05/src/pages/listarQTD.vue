<template>
  <div class="upd">
      <router-link to="/">----BACK---</router-link>
        <div><br>
            quantidade para mostrar: <input type="number" name="nome" v-model="qtd"><br>
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
           <button @click="chamarFuncao" type="button" > pegar medicos</button>
       </div>
  </div>
</template>

<script>
export default {
    data(){
        return {
            funs: [],
            qtd: 0,

            baseURI: "http://localhost:8080/api/medicos"
        };
    },
    methods:{
        chamarFuncao: function(){
    
            this.$http.get(this.baseURI + "/search?qtd=" + this.qtd).then((result) => {
                this.funs = result.data;
                console.log(this.funs);
            }).catch(function(error){
                console.log(error);
            })
            
            if(this.funs.length != this.qtd){
                let idp = this.funs.length - parseInt(this.id);
                for(let i = 1; i <= idp ;i++){
                    this.funs.pop();
                }
            }
        }
    }
}
</script>

<style>

</style>