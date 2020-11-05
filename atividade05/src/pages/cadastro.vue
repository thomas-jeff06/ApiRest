<template>
  <div class="cadastro">
       <router-link to="/">----BACK---</router-link>

       <div><br>
           Endereço: <input type="text" name="nome" v-model="endereco"><br>
           especialidade: <input type="text" name="nome" v-model="especialidade"><br>
           quantidade de vagas por dia: <input type="number" name="nome" v-model="vagas"><br>
           valor da consulta: <input type="number" name="nome" v-model="valor"><br>
           data da formatura: <input type="date" name="nome" v-model="data"><br>
           <button @click="postFun" type="button" > Enviar</button>
       </div>
  </div>
</template>

<script>
export default {
    data() {
        return {
            fun: {},
            endereco: '',
            especialidade: '',
            vagas: 0,
            valor: 0,
            data: '',
            baseURI: "http://localhost:8080/api/medicos"
            };
    },
    methods:{
        postFun: function(){
            let obj = {
                endereco: this.endereco,
                especialidade: this.especialidade,
                vagas: this.vagas,
                valor: this.valor,
                data: this.data
        };
            this.$http.post(this.baseURI, obj).then((result) => {
                this.fun = result.data;
                console.log("fun=:" + this.fun);
            }).catch(error => {
                console.log(error.message);
            });
            console.log(obj);
            alert('cadastro realizado');
                this.endereco = '';
                this.especialidade = '';
                this.vagas = 0;
                this.valor = 0;
                this.data = '';
        }
    }

}
</script>

<style>

</style>