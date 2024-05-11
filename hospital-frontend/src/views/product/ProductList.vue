<template>
  <div>
    <el-card>
      <!--搜索栏-->
      <el-row type="flex">
        <el-col :span="8">
          <el-input v-model="query" placeholder="请输入医疗产品名称查询">
            <el-button
                round
                slot="append"
                icon="iconfont icon-search-button"
                @click="requestProducts"
            ></el-button>
          </el-input>
        </el-col>
        <el-col :span="1"></el-col>
      </el-row>
      <el-row type="flex">
        <el-col :span="6">
          <br/>
          <el-button size="small" type="success" style="font-size: 15px" @click="addFormVisible = true">
            <i class="iconfont icon-add-button" style="font-size: 15px;"></i>
            增加医疗产品
          </el-button>
        </el-col>
      </el-row>

      <!--表格 -->
      <el-table :data="productData" size="small" stripe style="width: 100%" border>
        <el-table-column label="编号" prop="productId"/>
        <el-table-column label="医疗产品" prop="productName"/>
        <el-table-column label="说明">
          <template slot-scope="scope">
            <div style="white-space: pre-wrap;"> {{scope.row.productDescribe}} </div>
          </template>
        </el-table-column>
        <el-table-column label="操作" width="200" fixed="right">
          <template slot-scope="scope">
            <el-button
                size="small"
                style="font-size: 14px"
                type="success"
                @click="modifyDialog(scope.row.productId)"
            ><i class="iconfont icon-edit-button" style="font-size: 12px;"></i></el-button>
            <el-button
                size="small"
                style="font-size: 14px"
                type="danger"
                @click="deleteDialog(scope.row.productId)"
            ><i class="iconfont icon-delete-button" style="font-size: 12px;"></i></el-button>
          </template>
        </el-table-column>
      </el-table>

      <!-- 分页 -->
      <el-pagination
          @size-change="handleSizeChange"
          @current-change="handleCurrentChange"
          background
          layout="total, sizes, prev, pager, next, jumper"
          :current-page="pageNumber"
          :page-size="size"
          :page-sizes="[1, 2, 4, 8, 16]"
          :total="total"
      >
      </el-pagination>
    </el-card>

    <!-- 增加医疗产品对话框 -->
    <el-dialog title="增加医疗产品" :visible.sync="addFormVisible">
      <el-form :model="addForm" :rules="rules" ref="ruleForm">
        <el-form-item label="编号" prop="productId" label-width="80px">
          <el-input v-model.number="addForm.productId"></el-input>
        </el-form-item>
        <el-form-item label="名称" prop="productName" label-width="80px">
          <el-input v-model="addForm.productName"></el-input>
        </el-form-item>
        <el-form-item label="说明" prop="productDescribe" label-width="80px">
          <el-input type="textarea"
                    v-model="addForm.productDescribe"
                    autosize
          ></el-input>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button size="mini" @click="addFormVisible = false" style="font-size: 18px;">
          <i class="iconfont icon-cancel-button" style="font-size: 20px;"></i> 取 消
        </el-button>
        <el-button size="mini" type="primary" @click="addProduct('ruleForm')"style="font-size: 18px;">
          <i class="iconfont icon-sure-button" style="font-size: 20px;"></i> 确 定
        </el-button>
      </div>
    </el-dialog>

    <!-- 修改医疗产品药物对话框 -->
    <el-dialog title="修改医疗产品" :visible.sync="modifyFormVisible">
      <el-form :model="modifyForm" :rules="rules" ref="ruleForm">
        <el-form-item label="编号" prop="productId" label-width="80px">
          <el-input
              v-model.number="modifyForm.productId"
              disabled
          ></el-input>
        </el-form-item>
        <el-form-item label="名称" prop="productName" label-width="80px">
          <el-input v-model="modifyForm.productName"></el-input>
        </el-form-item>
        <el-form-item label="说明" prop="productDescribe" label-width="80px">
          <el-input  type="textarea"
                     v-model="modifyForm.productDescribe"
                     autosize
          ></el-input>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button size="mini"  @click="modifyFormVisible = false" style="font-size: 18px;">
          <i class="iconfont icon-cancel-button" style="font-size: 20px;"></i> 取 消
        </el-button>
        <el-button size="mini"  type="primary" @click="modifyProduct('ruleForm')"
                   style="font-size: 18px;"><i class="iconfont icon-r-yes" style="font-size: 20px;"></i> 确 定
        </el-button>
      </div>
    </el-dialog>
  </div>
</template>
<script>
import request from "@/utils/request.js";
export default {
  name: "ProductList",
  data() {
    return {
      pageNumber: 1,
      size: 8,
      query: "",
      productData: [],
      total: 3,
      addFormVisible: false,
      addForm: {},
      rules: {
        productId: [
          { required: true, message: "请输入编号", trigger: "blur" },
          {
            type: "number",
            message: "账号必须数字类型",
            trigger: "blur",
          },
        ],
        productName: [
          { required: true, message: "请输入名称", trigger: "blur" },
          {
            min: 1,
            max: 50,
            message: "账号必须是1到50个字符",
            trigger: "blur",
          },
        ],
        productDescribe: [
          { required: true, message: "请输入说明", trigger: "blur" },
        ],
      },
      modifyFormVisible: false,
      modifyForm: {},
    };
  },
  methods: {
    //点击修改药物信息
    modifyProduct(formName) {
      this.$refs[formName].validate((valid) => {
        if (valid) {
          request
              .get("product/modifyProduct", {
                params: {
                  productId: this.modifyForm.productId,
                  productName: this.modifyForm.productName,
                  productDescribe: this.modifyForm.productDescribe,
                },
              })
              .then((res) => {
                if (res.data.status !== 200)
                  return this.$message.error("修改医疗产品信息失败！");
                this.modifyFormVisible = false;
                this.requestProducts();
                this.$message.success("修改医疗产品信息成功！");
              });
        } else {
          return false;
        }
      });
    },
    //打开修改对话框
    modifyDialog(id) {
      request
          .get("product/findProduct", {
            params: {
              productId: id,
            },
          })
          .then((res) => {
            if (res.data.status !== 200)
              return this.$message.error("请求数据失败");
            this.modifyForm = res.data.data;
            this.modifyFormVisible = true;
          });
    },
    //删除医疗产品操作
    deleteProduct(id) {
      request
          .get("product/deleteProduct", {
            params: {
              productId: id,
            },
          })
          .then((res) => {
            this.requestProducts();
          });
    },
    //删除对话框
    deleteDialog(id) {
      this.$confirm("此操作将删除该医疗产品信息, 是否继续?", "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning",
      })
          .then(() => {
            this.deleteProduct(id);
            this.$message({
              type: "success",
              message: "删除成功!",
            });
          })
          .catch(() => {
            this.$message({
              type: "info",
              message: "已取消删除",
            });
          });
    },
    //点击增加确认按钮
    addProduct(formName) {
      this.$refs[formName].validate((valid) => {
        if (valid) {
          request
              .get("product/addProduct", {
                params: {
                  productId: this.addForm.productId,
                  productName: this.addForm.productName,
                  productDescribe: this.addForm.productDescribe,
                },
              })
              .then((res) => {
                if (res.data.status !== 200)
                  return this.$message.error(
                      "编号不合法或已被占用！"
                  );
                this.addFormVisible = false;
                this.requestProducts();
                this.$message.success("增加医疗产品成功！");
              });
        } else {
          return false;
        }
      });
    },
    //页面大小改变时触发
    handleSizeChange(size) {
      this.size = size;
      this.requestProducts();
    },
    //页码改变时触发
    handleCurrentChange(num) {
      this.pageNumber = num;
      this.requestProducts();
    },
    //加载医疗产品列表
    requestProducts() {
      request
          .get("product/findAllProducts", {
            params: {
              pageNumber: this.pageNumber,
              size: this.size,
              query: this.query,
            },
          })
          .then((res) => {
            this.productData = res.data.data.products;
            this.total = res.data.data.total;
          });
    },
  },
  created() {
    this.requestProducts();
  },
};
</script>
<style scoped lang="scss">
.el-table {
  margin-top: 20px;
  margin-bottom: 20px;
}
.el-form {
  margin-top: 0;
}
</style>
