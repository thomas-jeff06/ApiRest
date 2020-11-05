<template>
  <div class="filtros1">
      <router-link to="/">----BACK---</router-link><br>
        Digite Valor maximo: <input type="number" name="id" v-model="valor"><br>
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
        <button @click="fetchFunValor">pegar funcionarios</button>
    </div>
</template>

<script>
export default {
    name:"Cars",
    data() {
        return {
            funs: [],
            funsF:[],
            valor: 0,
            erros:[],
            baseURI: "http://localhost:8080/api/medicos"
        };
    },
    methods: {
        fetchFunValor: function() {
             this.$http.get(this.baseURI + "/searchValor?valor=" + this.valor).then((result) => {
                this.funs = result.data;
                console.log(this.funs);
            }).catch(function(error){
                console.log(error);
                this.errors.push(" não encontrado");
            })

            let max = this.funs.length
            for(let i = 0; i < max ;i++) {

			if(this.funs.valor < this.valor) {
				this.funsF[i] = this.funs[i]
				max--;
				i--;
			}else;
		}
    },
    },
};
</script>

<style>

</style>