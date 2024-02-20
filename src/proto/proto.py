import subprocess

def run_protoc_command(proto_file, proto_type , output_directory):
    command = ['protoc', f'--{proto_type}={output_directory}', proto_file]
    subprocess.run(command)

# 调用函数并传入相应的参数
proto_file = 'algorithm.proto'
output_java_directory = './java/'
output_python_directory = './python/'
java_type = 'java_out'
python_type = 'python_out'
run_protoc_command(proto_file, java_type,output_java_directory)
run_protoc_command(proto_file, python_type,output_python_directory)
