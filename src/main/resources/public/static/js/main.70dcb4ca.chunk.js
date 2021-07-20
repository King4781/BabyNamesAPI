(this["webpackJsonpbabynames-frontend"]=this["webpackJsonpbabynames-frontend"]||[]).push([[0],{117:function(e,a,t){e.exports={main:"Layout_main__31BWS",wrapper:"Layout_wrapper__2myUB"}},155:function(e,a,t){e.exports={documentation:"Documentation_documentation__3ALEI"}},157:function(e,a,t){e.exports={card:"Card_card__1UzoV"}},174:function(e,a,t){e.exports={message:"Message_message__2E0jv"}},176:function(e,a,t){e.exports={footer:"Footer_footer__1j53d"}},187:function(e,a,t){},326:function(e,a,t){"use strict";t.r(a);var n=t(0),c=t.n(n),r=t(84),s=t.n(r),i=(t(187),t(155)),l=t.n(i),j=t(2);var o=function(){return Object(j.jsx)("iframe",{className:l.a.documentation,src:"".concat("","/swagger-ui/"),title:"Api documentation",width:"100%"})};var b=function(){return Object(j.jsx)(o,{})},u=t(56),d=t.n(u),h=t(156),m=t(15),x=t(36),O=t.n(x),g=t(157),p=t.n(g);var _=function(e){return Object(j.jsx)("div",{style:{backgroundColor:e.bgColor,boxShadow:"0 2px 8px "+e.bgColor},className:p.a.card,children:e.children})},v=t(61),f=t.n(v);var y=function(e){var a,t="F"===e.baby.gender;return Object(j.jsxs)("div",{className:f.a.wrapper,children:[Object(j.jsx)("h2",{className:f.a.heading,children:t?"Female Information":"Male Information"}),Object(j.jsx)(_,{bgColor:t?"salmon":"blue",children:Object(j.jsxs)("div",{className:f.a.main,children:[Object(j.jsxs)("div",{children:[Object(j.jsx)("h1",{className:f.a.name,children:e.baby.name}),Object(j.jsxs)("h2",{children:[Object(j.jsx)("span",{className:f.a.ranking,children:e.baby.ranking})," ",Object(j.jsx)("em",{children:"Ranking"})]})]}),Object(j.jsxs)("div",{children:[Object(j.jsxs)("h3",{children:["YOB: ",e.baby.birthYear]}),Object(j.jsxs)("h3",{children:["Gender: ",(a=e.baby.gender,"M"===a?"Male":"Female")]}),Object(j.jsxs)("h3",{children:["Total Births: ",e.baby.totalBirths]})]})]})})]})},N=t(49),k=t.n(N);var S=function(e){var a,t=e.highestRanking,n=e.averageRanking;return Object(j.jsxs)("div",{className:k.a.wrapper,children:[Object(j.jsx)("h2",{className:k.a.heading,children:"Ranking Information"}),Object(j.jsx)(_,{bgColor:"DarkMagenta",children:Object(j.jsxs)("div",{className:k.a.main,children:[Object(j.jsxs)("div",{children:[Object(j.jsx)("h1",{className:k.a.name,children:t.name}),Object(j.jsx)("h2",{children:(a=n.gender,"neutral"===a.toLowerCase()?"Neutral":"M"===a?"Male":"Female")})]}),Object(j.jsxs)("div",{children:[Object(j.jsxs)("h3",{children:["Most recent highest ranking YOB: ",t.birthYear]}),Object(j.jsxs)("h3",{className:k.a.ranking,children:[Object(j.jsx)("span",{children:t.ranking})," ",Object(j.jsx)("em",{children:"Highest Ranking"})]}),Object(j.jsxs)("h3",{className:k.a.ranking,children:[Object(j.jsx)("span",{children:n.averageRanking})," ",Object(j.jsx)("em",{children:"Average Ranking"})]})]})]})})]})},R=t(328),F=t(178),w=t(332),C=t(76),M=t(72),B=t(172),P=t(173),L=t(91),D=t.n(L);var I=function(e){var a,t=e.popularityStats,n=t.decades.map((function(e){return{name:e.decade,Ranking:e.ranking}}));return Object(j.jsxs)("div",{className:D.a.main,children:[Object(j.jsxs)("h2",{className:D.a.heading,children:["Popularity Information for ",t.name]}),Object(j.jsxs)("h3",{className:D.a.heading,children:["Gender: ",(a=t.gender,"neutral"===a.toLowerCase()?"Neutral":"M"===a?"Male":"Female")]}),Object(j.jsxs)(R.a,{width:800,height:400,data:n,children:[Object(j.jsx)(F.a,{type:"monotone",dataKey:"Ranking",stroke:"#8884d8"}),Object(j.jsx)(w.a,{stroke:"#ccc"}),Object(j.jsx)(C.a,{}),Object(j.jsx)(M.a,{}),Object(j.jsx)(B.a,{dataKey:"name"}),Object(j.jsx)(P.a,{reversed:!0})]})]})},T=t(174),Y=t.n(T);for(var A=function(e){return Object(j.jsx)(_,{bgColor:e.color,children:Object(j.jsx)("div",{className:Y.a.message,children:Object(j.jsx)("h1",{children:e.message})})})},E=Object(n.createContext)({babyName:null,babyStats:null,popularityStats:null}),G=function(e){var a=e.children,t=Object(n.useState)(null),c=Object(m.a)(t,2),r=c[0],s=c[1],i=Object(n.useState)(null),l=Object(m.a)(i,2),o=l[0],b=l[1],u=Object(n.useState)(null),d=Object(m.a)(u,2),h={babyName:r,setBabyName:s,babyStats:o,setBabyStats:b,popularityStats:d[0],setPopularityStats:d[1]};return Object(j.jsx)(E.Provider,{value:h,children:a})},K=E,Q=[],U=2010;U<=2014;U++)Q.push(U);var z=function(){var e=Object(n.useContext)(K),a=e.babyName,t=e.setBabyName,c=e.babyStats,r=e.setBabyStats,s=e.popularityStats,i=e.setPopularityStats,l=Object(n.useState)(""),o=Object(m.a)(l,2),b=o[0],u=o[1],x=Object(n.useState)(Q[0]),g=Object(m.a)(x,2),p=g[0],_=g[1],v=Object(n.useState)("Neutral"),f=Object(m.a)(v,2),N=f[0],k=f[1],R=Object(n.useState)(!1),F=Object(m.a)(R,2),w=F[0],C=F[1],M=Object(n.useState)(!1),B=Object(m.a)(M,2),P=B[0],L=B[1],D=Object(n.useState)(!1),T=Object(m.a)(D,2),Y=T[0],E=T[1],G=Object(n.useState)(!1),U=Object(m.a)(G,2),z=U[0],H=U[1],J=Object(n.useState)(!1),V=Object(m.a)(J,2),q=V[0],W=V[1],X="".concat("/api/babies","/search/year/").concat(p,"/name/").concat(b,"?exact=true&gender=").concat(N),Z="".concat("/api/babies","/ranking/name/").concat(b,"?gender=").concat(N),$="".concat("/api/babies","/average/name/").concat(b,"?gender=").concat(N),ee="".concat("/api/babies","/popularity/name/").concat(b,"?gender=").concat(N);function ae(){return(ae=Object(h.a)(d.a.mark((function e(a){var n,c,s,l,j,o,h,m,x;return d.a.wrap((function(e){for(;;)switch(e.prev=e.next){case 0:if(a.preventDefault(),b&&p&&N){e.next=3;break}return e.abrupt("return");case 3:return t(null),r(null),i(null),e.prev=6,E(!0),e.next=10,fetch(X);case 10:return n=e.sent,e.next=13,n.json();case 13:if(0!==(c=e.sent).babies.length){e.next=22;break}return L(!0),t(null),r(null),i(null),E(!1),setTimeout((function(){L(!1)}),5e3),e.abrupt("return");case 22:return t(c),E(!1),H(!0),e.next=27,fetch(Z);case 27:return s=e.sent,e.next=30,s.json();case 30:return l=e.sent,e.next=33,fetch($);case 33:return j=e.sent,e.next=36,j.json();case 36:return o=e.sent,e.next=39,Promise.all([l,o]);case 39:return h=e.sent,r(h),H(!1),W(!0),e.next=45,fetch(ee);case 45:return m=e.sent,e.next=48,m.json();case 48:x=e.sent,i(x),W(!1),e.next=62;break;case 53:e.prev=53,e.t0=e.catch(6),C(!0),t(null),r(null),E(!1),H(!1),W(!1),setTimeout((function(){C(!1)}),5e3);case 62:u("");case 63:case"end":return e.stop()}}),e,null,[[6,53]])})))).apply(this,arguments)}return Object(j.jsxs)(n.Fragment,{children:[Object(j.jsx)("header",{className:O.a.header,children:Object(j.jsx)("h1",{children:"Find fun facts about your name!"})}),Object(j.jsx)("section",{className:O.a.main,children:Object(j.jsxs)("form",{className:O.a.form,onSubmit:function(e){return ae.apply(this,arguments)},children:[Object(j.jsxs)("div",{className:O.a.name,children:[Object(j.jsx)("label",{htmlFor:"name",children:"First Name"}),Object(j.jsx)("input",{value:b,onChange:function(e){return u(e.target.value)},id:"name",placeholder:"Enter a first name",type:"text",required:!0})]}),Object(j.jsxs)("div",{className:O.a.year,children:[Object(j.jsx)("label",{htmlFor:"year",children:"Birth Year"}),Object(j.jsx)("select",{id:"year",value:p,onChange:function(e){return _(e.target.value)},children:Q.map((function(e){return Object(j.jsx)("option",{children:e},e)}))})]}),Object(j.jsxs)("div",{className:O.a.gender,children:[Object(j.jsx)("label",{htmlFor:"gender",children:"Gender"}),Object(j.jsxs)("select",{id:"gender",value:N,onChange:function(e){return k(e.target.value)},children:[Object(j.jsx)("option",{value:"neutral",children:"Neutral"}),Object(j.jsx)("option",{value:"M",children:"Male"}),Object(j.jsx)("option",{value:"F",children:"Female"})]})]}),Object(j.jsx)("div",{className:O.a.submit,children:Object(j.jsx)("button",{type:"submit",children:"Get Info"})})]})}),Object(j.jsxs)("section",{className:O.a.searchResult,children:[P&&Object(j.jsx)(A,{color:"#6c757d",message:"".concat(b," was not found in the year ").concat(p,".")}),w&&Object(j.jsx)(A,{color:"#dc3545",message:"A error occured. Please try again later."}),Y&&Object(j.jsx)(A,{color:"DarkCyan",message:"Loading name stats ....."}),a&&a.babies.map((function(e){return Object(j.jsx)(y,{baby:e},e.id)})),z&&Object(j.jsx)(A,{color:"DarkCyan",message:"Loading ranking stats ....."}),c&&Object(j.jsx)(S,{highestRanking:c[0],averageRanking:c[1],gender:N}),q&&Object(j.jsx)(A,{color:"DarkCyan",message:"Loading popularity stats ....."}),s&&Object(j.jsx)(I,{popularityStats:s})]})]})};var H=function(){return Object(j.jsx)(z,{})},J=t(75),V=t.n(J),q=t(60);var W=function(){return Object(j.jsxs)("header",{className:V.a.header,children:[Object(j.jsx)("div",{className:V.a.logo,children:Object(j.jsx)(q.b,{to:"/",children:"Baby Names API"})}),Object(j.jsx)("nav",{children:Object(j.jsxs)("ul",{children:[Object(j.jsx)("li",{children:Object(j.jsx)(q.c,{activeClassName:V.a.active,to:"/",children:"Search"})}),Object(j.jsx)("li",{children:Object(j.jsx)(q.c,{activeClassName:V.a.active,to:"/documentation",children:"Documentation"})})]})})]})},X=t(176),Z=t.n(X);var $=function(){return Object(j.jsx)("footer",{className:Z.a.footer,children:Object(j.jsx)("a",{href:"https://kentonking.tech/",children:"kentonking.tech"})})},ee=t(117),ae=t.n(ee);var te=function(e){return Object(j.jsxs)("div",{className:ae.a.wrapper,children:[Object(j.jsx)(W,{}),Object(j.jsx)("main",{className:ae.a.main,children:e.children}),Object(j.jsx)($,{})]})},ne=t(18);s.a.render(Object(j.jsx)(c.a.StrictMode,{children:Object(j.jsx)(G,{children:Object(j.jsx)(q.a,{children:Object(j.jsx)(te,{children:Object(j.jsxs)(ne.c,{children:[Object(j.jsx)(ne.a,{path:"/documentation",children:Object(j.jsx)(b,{})}),Object(j.jsx)(ne.a,{path:"/",children:Object(j.jsx)(H,{})})]})})})})}),document.getElementById("root"))},36:function(e,a,t){e.exports={header:"SearchForm_header__2Qi2n",main:"SearchForm_main__22ThL",form:"SearchForm_form__-h0uD",name:"SearchForm_name__28a8I",year:"SearchForm_year__3P5OK",gender:"SearchForm_gender__jDKur",submit:"SearchForm_submit__3dQT1",searchResult:"SearchForm_searchResult__3NYvC"}},49:function(e,a,t){e.exports={wrapper:"RankingResult_wrapper__PMty5",heading:"RankingResult_heading__1S39y",main:"RankingResult_main__3tPeG",ranking:"RankingResult_ranking__L3zLE",name:"RankingResult_name__1vpwm"}},61:function(e,a,t){e.exports={wrapper:"SearchResult_wrapper__11syK",heading:"SearchResult_heading__2OdUN",main:"SearchResult_main__3TQw0",ranking:"SearchResult_ranking__3lVai",name:"SearchResult_name__2P2lF"}},75:function(e,a,t){e.exports={header:"MainNavigation_header__1gLjk",logo:"MainNavigation_logo__dp5Sa",active:"MainNavigation_active__3_bHB"}},91:function(e,a,t){e.exports={main:"PopularityResults_main__2x4lb",heading:"PopularityResults_heading__3df6D"}}},[[326,1,2]]]);
//# sourceMappingURL=main.70dcb4ca.chunk.js.map