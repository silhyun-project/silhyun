<template>
<div>
    <form><input><input><button>login</button>
    <button type="button" @click="gopage">회원가입</button>
</div>
</template>

<script>
module.exports = {
    data: function() {
        return {
            who: 'world'
        }
    },
    methods: {
        gopage : function(){
            this.$router.push('/signin')
        },
    }
}
</script>

<style>
.hello {
    background-color: #ffe;
}
</style>