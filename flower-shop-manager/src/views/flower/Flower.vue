<template>
	<div>
		<el-table style="width: 100%" :data="flowers" :header-cell-style="{'text-align':'center'}"
			:cell-style="{'text-align':'center'}">
			<el-table-column label="图片">
				<template slot-scope="scope">
					<img style="width:30px;height:30px;border:none;" :src="scope.row.image">
				</template>
			</el-table-column>
			<el-table-column label="代码" prop="name" />
			<el-table-column label="花名" prop="name" />
			<el-table-column label="市场价" prop="marketPrice" />
			<el-table-column label="折扣价" prop="specialPrice" />
			<el-table-column label="存量" prop="stock" />
			<el-table-column label="已销售" prop="num" />
			<el-table-column label="星指数" prop="stars" />
			<el-table-column label="上架时间" class="is-center">
				<template slot-scope="scope">
					<i class="el-icon-time"></i>
					<span style="margin-left: 10px">{{scope.row.createTime | formatDate}}</span>
				</template>
			</el-table-column>
			<el-table-column label="操作" min-width="120" class="is-center">
				<template slot-scope="scope">
					<el-button size="mini" @click="editOne(scope.$index, scope.row)">编辑</el-button>
					<el-button size="mini" type="danger" @click="handleDelete(scope.$index, scope.row)">删除</el-button>
				</template>
			</el-table-column>
		</el-table>

		<router-view></router-view>
		<el-dialog :visible.sync="flowerDialogVisible" :model="flower" width="40%" center="center"
			:append-to-body="true">
			<el-form ref="formRef" label-width="90px" style="width: 95%;margin: 0 auto">
				<el-form-item label="上传图片" ref="uploadElement" prop="imageUrl">
					<el-input v-model="flower.image" v-if="false"></el-input>
					<el-upload class="avatar-uploader" ref="upload" :show-file-list="false" action="/index/upload"
						:before-upload="beforeUpload" :on-change="handleChange" :auto-upload="false" :data="flower">
						<img style="width:100px" v-if="flower.image" :src="flower.image" class="avatar">
						<i v-else class="el-icon-plus avatar-uploader-icon"></i>
					</el-upload>
				</el-form-item>
				<el-form-item label="花名" prop="name">
					<el-input type="age" v-model="flower.name" autocomplete="off"></el-input>
				</el-form-item>
				<el-form-item label="市场价" prop="name">
					<el-input type="age" v-model="flower.marketPrice" autocomplete="off"></el-input>
				</el-form-item>
				<el-form-item label="折扣价" prop="name">
					<el-input type="age" v-model="flower.specialPrice" autocomplete="off"></el-input>
				</el-form-item>
				<el-form-item label="存量" prop="name">
					<el-input type="age" v-model="flower.stock" autocomplete="off"></el-input>
				</el-form-item>
				<el-form-item label="已销售" prop="name">
					<el-input type="age" v-model="flower.num" autocomplete="off"></el-input>
				</el-form-item>
				<el-form-item label="星指数" prop="name">
					<el-input type="age" v-model="flower.stars" autocomplete="off"></el-input>
				</el-form-item>
				<el-form-item label="上架时间" prop="name">
					<el-input type="age" v-model="flower.createTime" autocomplete="on"></el-input>
				</el-form-item>
				<div style="display:flex;justify-content: flex-end">
					<el-button type="primary" size="small" @click="confirm()">编 辑</el-button>
					<el-button size="small" @click="cancel()">取 消</el-button>
				</div>
			</el-form>
		</el-dialog>
	</div>
</template>

<script>
	export default {
		data() {
			return {
				flowers: [],
				flower: '',
				flowerDialogVisible: false,
				flowerIndex: ''
			}
		},
		methods: {
			getFlowers() {
				this.axios({
					method: 'get',
					url: this.GLOBAL.BASE_URL + 'flower/list',
				}).then((res) => {
					if (res.data.code === 1) {
						this.flowers = res.data.data
					}
					if (res.data.code !== 1) {
						console.log('接口' + this.GLOBAL.BASE_URL + 'flower/list' + '请求失败')
						console.log('原因为：' + res.data.msg, '状态码为：' + res.data.code)
					}
				})
			},
			handleEdit(index, flower) {
				console.log("index:", index)
				console.log("flower:", flower)
			},
			handleDelete(index, flower) {
				console.log("index:", index)
				console.log("flower:", flower)
			},
			editOne(index, value) {
				this.flower = value
				this.flowerIndex = index
				this.flowerDialogVisible = true
			},
			confirm() {
				this.flowerDialogVisible = false
			},
			cancel() {
				this.flower = this.flowers[this.flowerIndex]
				this.flowerDialogVisible = false
			},
			handleChange(file, fileList) {
				console.log(file,fileList)
				console.log('>>>>>file的情况：',file)
			},
			beforeUpload(file) {
				console.log(file)
				return true;
			},
		},

		created() {
			this.getFlowers()
		},
		filters: {
			formatDate: function(value) {
				let date = new Date(value);
				let y = date.getFullYear();
				let MM = date.getMonth() + 1;
				MM = MM < 10 ? ('0' + MM) : MM;
				let d = date.getDate();
				d = d < 10 ? ('0' + d) : d;
				// let h = date.getHours();
				// h = h < 10 ? ('0' + h) : h;
				// let m = date.getMinutes();
				// m = m < 10 ? ('0' + m) : m;
				// let s = date.getSeconds();
				// s = s < 10 ? ('0' + s) : s;
				return y + '-' + MM + '-' + d + ' ';
			}
		},
		computed: {}

	}
</script>
