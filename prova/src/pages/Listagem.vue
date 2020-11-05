<template>
  <div class="lista">
      <router-link to="/">----BACK---</router-link>
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
        <button @click="fetchUsers">get users</button>
  </div>
</template>

<script>
export default {
    data() {
    return {
        funs: [],
        baseURI: "http://localhost:8080/api/medicos"
        };
    },
    methods:{
        fetchUsers: function() {
            this.$http.get(this.baseURI).then((result) => {
            this.funs = result.data;
            console.log(this.funs);
            });
        },
    },
};
</script>

<style>
table{
    width: 60%;
    margin-left: 280px;
    border: 0;
    border-collapse: separate;
    font-size: 12px;
    text-align: left;
    padding: 10px;

}
th{
    border-left: 1px solid black;
    border-top: 1px solid black;
    
}
  
  thead {
    background-color: white;
}
  
  tbody {
    min-width: 200px;
    background-color: rgb(244, 246, 247);
}
</style>