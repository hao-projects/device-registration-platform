webpackJsonp([26],{174:function(e,t,n){function a(e){n(317)}var o=n(3)(n(252),n(348),a,"data-v-5c10dcc2",null);e.exports=o.exports},252:function(e,t,n){"use strict";Object.defineProperty(t,"__esModule",{value:!0});var a=n(13),o=n.n(a),s=n(5);t.default={data:function(){return{form:{options:[{value:"transChange",label:"改造变更"},{value:"moveChange",label:"移装变更"},{value:"compChange",label:"单位变更"},{value:"nameChange",label:"更名变更"},{value:"ageChange",label:"达到设计年限变更"}],selectedOptions:[],num1:1},active:1,ifNext:!0,dev_id:"",dev_name:""}},methods:o()({},n.i(s.b)({selectedChange:"selectedChange"}),{onSubmit:function(){console.log("submit!")},handleChange:function(e){console.log(e),this.selectedChange(e),console.log(this.getSelectedChangeOption),e&&(this.ifNext=!1)},next:function(){"transChange"==this.getSelectedChangeOption&&this.$router.push("transformChange")},transparam:function(){this.$route.query.dev_id&&(this.dev_id=this.$route.query.dev_id),this.$route.query.dev_name&&(this.dev_name=this.$route.query.dev_name,console.log(this.dev_name))}}),mounted:function(){this.transparam()},computed:o()({},n.i(s.c)(["selectedChangeOption"]),n.i(s.a)(["getSelectedChangeOption"])),watch:{$route:"transparam"}}},288:function(e,t,n){t=e.exports=n(166)(!0),t.push([e.i,"","",{version:3,sources:[],names:[],mappings:"",file:"changeReq.vue",sourceRoot:""}])},317:function(e,t,n){var a=n(288);"string"==typeof a&&(a=[[e.i,a,""]]),a.locals&&(e.exports=a.locals);n(167)("12a52a70",a,!0)},348:function(e,t){e.exports={render:function(){var e=this,t=e.$createElement,n=e._self._c||t;return n("div",{staticClass:"changeReq"},[n("h2",[e._v("变更申请")]),e._v(" "),n("div",{staticClass:"content-box"},[n("Form",{attrs:{model:e.form,"label-width":100}},[n("Form-item",{attrs:{label:"变更设备"}},[n("p",[e._v(e._s(this.dev_name))])]),e._v(" "),n("Form-item",{attrs:{label:"变更申请种类"}},[n("Select",{staticStyle:{width:"200px"},on:{"on-change":e.handleChange},model:{value:e.form.selectedOptions,callback:function(t){e.form.selectedOptions=t},expression:"form.selectedOptions"}},e._l(e.form.options,function(t){return n("Option",{key:t.value,attrs:{value:t.value}},[e._v(e._s(t.label))])}))],1),e._v(" "),n("Button",{attrs:{type:"primary",disabled:e.ifNext},on:{click:e.next}},[e._v("下一步")])],1)],1)])},staticRenderFns:[]}}});
//# sourceMappingURL=26.626e8b4824bd3961c870.js.map