//创建Vuex中的store
import Vuex from "vuex";
import Vue from "vue";
import items from './modules/items'

Vue.use(Vuex);

const actions = {
    text(context, value) {
        context.commit('TEXT', value);
        console.log(context);
    },
};
const mutations = {

};
const state = {
    drawer:false,
};

export default new Vuex.Store({
    actions, //简写形式
    mutations,
    state,
    modules: {
        items,
    }
});