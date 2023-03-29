<template>

  <div>

    <div ref='pdiv' @click='showSelectC'>
      <a-input :disabled='true' v-model='${model_name}Name' :placeholder="$t('${bean_name}.clickSelect')"></a-input>
    </div>
    <a-modal v-model='showSelect' width='1200px' @ok='handleOk'>
      <div class='table-page-search-wrapper'>
        <a-form layout='inline' @keyup.enter.native='searchQuery'>
          <a-row :gutter='24'>
           <#list col_List as po>
	            <#if po.isQuery == 'yes'> <#-- 如果这一列需要搜索 -->
		            <a-col :md="6" :sm="8">
		                <a-form-item :label="$t('${bean_name}.${po.filed}')" >   
		                	<a-input v-model="pageInfo.condition.${po.filed}"></a-input>
		                </a-form-item>
		            </a-col>
	            </#if>    	
           </#list>   
            <a-col :md='6' :sm='8'>
                <span style='float: left;overflow: hidden;' class='table-page-search-submitButtons'>
                  <a-button type='primary' @click='searchQuery' icon='search'>{{ $t('common.query') }}</a-button>
                </span>
            </a-col>
          </a-row>
        </a-form>
      </div>

      <div>
        <a-table
          size='middle'
          rowKey='id'
          width='300'
          :scroll='{x:true}'
          :columns='columns'
          :dataSource='dataSource'
          :pagination='pageInfo'
          :loading='loading'
          :customRow='itemSelect'
          @change='handleTableChange'

        >
        </a-table>
      </div>
    </a-modal>
  </div>


</template>

<script>
import API from '@/api/${bean_name}'
import { JeecgListMixin } from '@/mixins/JeecgListMixin'

export default {
  name: 'LaisonInput${bean_name}Select',
  mixins: [JeecgListMixin],
  components: {},
  props: ['conditions', 'options', 'value'],
  watch: {
    value: {
      handler(newValue, oldValue) {
	      if(this.value != newValue){
	      	this.value = newValue
	      }
      },
      deep: true,
      // 代表在wacth里声明了firstName这个方法之后立即先去执行handler方法，如果设置了false，那么效果和上边例子一样
      immediate: true
    }
  },
  data() {
    return {

      loading: true,
      ${model_name}Name: null,
      showSelect: false,
      current${bean_name}: null,
      orderByClause:'${orderByClause}',
      columns: [
         <#list col_List as po>
            {
                title: this.$t('${bean_name}.${po.filed}'),
                align: "center",
                dataIndex: '${po.filed}'
            },
         </#list>
      ]
    }
  },


  created() {
    this.pageInfo.condition.orderByClause = this.orderByClause
    this.pageInfo.condition.delFlag = 0
    if (this.conditions) {
      for (let k in this.conditions) {
        this.pageInfo.condition[k] = this.conditions[k]
      }
    }
    this.loadData()

	if(this.value){
	
		 API.findById(this.value).then(res => {
		      this.current${bean_name} = res
		      if (this.current${bean_name}) {
		       this.${model_name}Name = this.current${bean_name}.${model_name}Name //自动生成的修改成res中对应的属性名
	    	  }
	     })
		
	    
	}
    


  },
  methods: {

    show() {
      this.loadData()
    },
    itemSelect(record, index) {
      return {
        on: {
          click: () => {
            this.current${bean_name} = record
            this.${model_name}Name =  record.${model_name}Name  //自动生成的修改成res中对应的属性名
           
            this.$emit('input',record);
            this.$emit('change', record)
            this.showSelect = false
          }
        }
      }

    },
    showSelectC() {
      console.log(this.value)
      if (!(this.options && this.options.disabled)) {
        
        API.findByPage(this.pageInfo).then(
        (res) => {
          this.dataSource = res.list
          this.pageInfo.total = res.total
          this.loading = false
          this.showSelect = true
        }
        
      )
      }
    },
    handleOk() {
      this.showSelect = false
    },
    loadData() {
      //this.current${bean_name} = null
      API.findByPage(this.pageInfo).then(
        (res) => {
          this.dataSource = res.list
          this.pageInfo.total = res.total
          this.loading = false
        }
      )
    }
  },
  mounted() {

  }
}
</script>

<style scoped>
.ant-input[disabled] {
  background-color: transparent;
  cursor: pointer;
  opacity: 1;
  color: #000;
}
</style>